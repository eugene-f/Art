package kz.ef.art.vision.sandbox;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import static kz.ef.art.vision.sandbox.VisionEffectsPrefStorage.*;

public class VisionSettingsFrame extends JFrame implements ChangeListener, ItemListener, ActionListener {

    private JPanel rootPanel;
    private JCheckBox hsvCheckBox;
    private JCheckBox binCheckBox;
    private JCheckBox dilateCheckBox;
    private JSlider dilateRadiusSlider;
    private JSlider dilateIterationsSlider;
    private JCheckBox erodeCheckBox;
    private JSlider erodeRadiusSlider;
    private JSlider erodeIterationsSlider;
    private JSlider colorRedMinSlider;
    private JSlider colorRedMaxSlider;
    private JSlider colorGreenMinSlider;
    private JSlider colorGreenMaxSlider;
    private JSlider colorBlueMinSlider;
    private JSlider colorBlueMaxSlider;
    private JButton updateButton;
    private JCheckBox autoUpdateChannelsCheckBox;

    public void setJSliderParams(JSlider slider, int max, int minor, int major, ChangeListener changeListener) {
        slider.setMinimum(0);
        slider.setMaximum(max);
        slider.setValue(1);
        slider.setMinorTickSpacing(minor);
        slider.setMajorTickSpacing(major);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(changeListener);
    }

    public VisionSettingsFrame() {
        setTitle("Параметры зрения");
        setLocationRelativeTo(null);
        setContentPane(rootPanel);
//        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        hsvCheckBox.addItemListener(this);
        binCheckBox.addItemListener(this);

        dilateCheckBox.addItemListener(this);
        setJSliderParams(dilateRadiusSlider, dilateRadiusMax, 1, 5, this);
        setJSliderParams(dilateIterationsSlider, dilateIterationsMax, 1, 5, this);

        erodeCheckBox.addItemListener(this);
        setJSliderParams(erodeRadiusSlider, erodeRadiusMax, 1, 5, this);
        setJSliderParams(erodeIterationsSlider, erodeIterationsMax, 1, 5, this);

        setJSliderParams(colorRedMinSlider, channelRgbMax, 32, 255, this);
        setJSliderParams(colorRedMaxSlider, channelRgbMax, 32, 255, this);
        setJSliderParams(colorGreenMinSlider, channelRgbMax, 32, 255, this);
        setJSliderParams(colorGreenMaxSlider, channelRgbMax, 32, 255, this);
        setJSliderParams(colorBlueMinSlider, channelRgbMax, 32, 255, this);
        setJSliderParams(colorBlueMaxSlider, channelRgbMax, 32, 255, this);

        updateButton.addActionListener(this);

        autoUpdateChannelsCheckBox.addItemListener(this);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
        if (source == updateButton) {
            showChannelsFlag = true;
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() instanceof JSlider) {
            JSlider slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                if (slider == dilateRadiusSlider) dilateRadius = slider.getValue();
                if (slider == dilateIterationsSlider) dilateIterations = slider.getValue();
                if (slider == erodeRadiusSlider) erodeRadius = slider.getValue();
                if (slider == erodeIterationsSlider) erodeIterations = slider.getValue();
                if (slider == colorRedMinSlider) rMin = slider.getValue();
                if (slider == colorRedMaxSlider) rMax = slider.getValue();
                if (slider == colorGreenMinSlider) gMin = slider.getValue();
                if (slider == colorGreenMaxSlider) gMax = slider.getValue();
                if (slider == colorBlueMinSlider) bMin = slider.getValue();
                if (slider == colorBlueMaxSlider) bMax = slider.getValue();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() instanceof JCheckBox) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            if (checkBox == hsvCheckBox) hsvFlag = checkBox.isSelected();
            if (checkBox == binCheckBox) binFlag = checkBox.isSelected();
            if (checkBox == erodeCheckBox) erodeFlag = checkBox.isSelected();
            if (checkBox == dilateCheckBox) dilateFlag = checkBox.isSelected();
            if (checkBox == autoUpdateChannelsCheckBox) {
                autoUpdateChannelsFlag = checkBox.isSelected();
                showChannelsFlag = autoUpdateChannelsFlag;
            }
        }
    }

}
