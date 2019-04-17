package com.allst.jcore.i18n;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

/**
 * Java Core技术学习 -- i18n
 * @author June
 * 2018/04/19
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new NumberFormatFrame();
                frame.setTitle("NumberFormatTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
class NumberFormatFrame extends JFrame {
    private Locale[] locales;
    private double currentNumber;
    private JComboBox<String> localeCombo = new JComboBox<>();
    private JButton parseButton = new JButton("Parse");
    private JTextField numberText = new JTextField(30);
    private JRadioButton numberRadioButton = new JRadioButton("Number");
    private JRadioButton currencyRadioButton = new JRadioButton("Currency");
    private JRadioButton percentRadioButton = new JRadioButton("Percent");
    private ButtonGroup rbGroup = new ButtonGroup();
    private NumberFormat currentNumberFormat;



    public NumberFormatFrame() {
        setLayout(new GridBagLayout());
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        };
        JPanel p = new JPanel();
        addRadioButton(p, numberRadioButton, rbGroup, listener);
        addRadioButton(p, currencyRadioButton, rbGroup, listener);
        addRadioButton(p, percentRadioButton, rbGroup, listener);

//        add(new JLabel("Locale:"), new );
        locales = (Locale[])NumberFormat.getAvailableLocales().clone();
        Arrays.sort(locales, new Comparator<Locale>() {
            @Override
            public int compare(Locale o1, Locale o2) {
                return o1.getDisplayName().compareTo(o2.getDisplayName());
            }
        });
        for (Locale loc : locales) {
            localeCombo.addItem(loc.getDisplayName());
            localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
            currentNumber = 123456.78;
            updateDisplay();

            localeCombo.addActionListener(listener);
//            parseButton.addAncestorListener((ActionListener) event -> {
//                String s = numberText.getText().trim();
//                try {
//                    Number n = currentNumberFormat.parse(s);
//                    if (n != null) {
//                        currentNumber = n.doubleValue();
//                        updateDisplay();
//                    } else {
//                        numberText.setText("parse error:" + s);
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            });
            pack();
        }
    }

    public void addRadioButton(Container p, JRadioButton b, ButtonGroup g, ActionListener listener) {
        b.setSelected(g.getButtonCount() == 0);
        b.addActionListener(listener);
        g.add(b);
        p.add(b);
    }

    public void updateDisplay() {
        Locale currentLocale = locales[localeCombo.getSelectedIndex()];
        currentNumberFormat = null;
        if (numberRadioButton.isSelected()) {
            currentNumberFormat = NumberFormat.getNumberInstance(currentLocale);
        }
        else if (currencyRadioButton.isSelected()) {
            currentNumberFormat = NumberFormat.getCurrencyInstance(currentLocale);
        }
        else if (percentRadioButton.isSelected()) {
            currentNumberFormat = NumberFormat.getPercentInstance(currentLocale);
        }
        String n = currentNumberFormat.format(currentNumber);
        numberText.setText(n);
    }
}