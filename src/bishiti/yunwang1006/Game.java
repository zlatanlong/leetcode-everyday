package bishiti.yunwang1006;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game {
    private static int count = 200;

    private static final String OFF_STRING = "DOWN";

    private static final String ON_STRING = "UP";

    private static final String HIT_STRING = "HIT";

    private static final Color OFF_COLOR = Color.GRAY;

    private static final Color ON_COLOR = Color.GREEN;

    private static final Color HIT_COLOR = Color.RED;

    private JButton[] buttons;

    private static Random random = new Random();

    private static JTextField score;

    private JLabel scoreText;

    private JTextField timeLeft;

    private JLabel timeLeftText;

    private JButton start;

    private static int finalScore;

    private static volatile boolean flag;

    private Thread[] threads;

    public Game(int nums) {
        finalScore = 0;
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 20);


        JFrame window = new JFrame("Mole");
        window.setBounds(1000, 500, 1000, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.getContentPane().setLayout(null);

        JPanel firstPanel = new JPanel();

        JPanel secondPanel = new JPanel();

        secondPanel.setLayout(new GridLayout(3, 4, 20, 20));

        start = new JButton();
        start.setText("Start");
        start.setFont(font);

        firstPanel.add(start);

        timeLeftText = new JLabel();
        timeLeftText.setText("Time Left:");
        timeLeftText.setFont(font);
        firstPanel.add(timeLeftText);


        timeLeft = new JTextField();
        timeLeft.setColumns(5);
        timeLeft.setEditable(false);
        timeLeft.setFont(font);
        firstPanel.add(timeLeft);

        scoreText = new JLabel();
        scoreText.setText("Score");
        scoreText.setFont(font);
        firstPanel.add(scoreText);

        score = new JTextField();
        score.setColumns(5);
        score.setEditable(false);
        score.setFont(font);
        firstPanel.add(score);

        buttons = new JButton[nums];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(OFF_STRING);
            buttons[i].setBackground(OFF_COLOR);
            buttons[i].setOpaque(true);
            buttons[i].setFont(font);
            buttons[i].setPreferredSize(new Dimension(100, 40));

            int finalI = i;
            buttons[i].addActionListener(e -> {
                if (buttons[finalI].getText().equals(ON_STRING)) {
                    finalScore++;
                    score.setText(String.valueOf(finalScore));
                    buttons[finalI].setText(HIT_STRING);
                    buttons[finalI].setBackground(HIT_COLOR);
                    System.out.println("aaaaa");

//                    try {
//                        synchronized (buttons[finalI]) {
//                            threads[finalI].wait(1000);
//                        }
//                    } catch (InterruptedException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                    buttons[finalI].setBackground(OFF_COLOR);
//                    buttons[finalI].setText(OFF_STRING);
//                    System.out.println("bbbb");
                }
            });
            secondPanel.add(buttons[i]);
        }

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threads = new Mole[nums];
                for (int i = 0; i < buttons.length; i++) {
                    threads[i] = new Mole(buttons[i]);
                }
                score.setText("0");
                start.setEnabled(false);
                flag = true;
//                count = 20;
                finalScore = 0;
                for (int i = 0; i < nums; i++) {
                    threads[i].start();
                }
                Thread timer = new TimeCount(timeLeft, start, threads);
                timer.start();

            }
        });
        window.setVisible(true);
        window.setContentPane(firstPanel);
        window.getContentPane().add(secondPanel);


    }

    private static class TimeCount extends Thread {
        private JTextField myScoreText;
        private JButton myStrat;
        private Thread[] moles;

        public TimeCount(JTextField myScoreText, JButton myStrat, Thread[] moles) {
            this.myScoreText = myScoreText;
            this.myStrat = myStrat;
            this.moles = moles;
        }

        @Override
        public void run() {
            while (count >= 0) {
                try {
                    Thread.sleep(1000);
                    myScoreText.setText(String.valueOf(count));
                    count--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < moles.length; i++) {
                moles[i].interrupt();
            }
            flag = false;

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myStrat.setEnabled(true);
            super.run();
        }
    }


    private static class Mole extends Thread {
        private JButton button;

        public Mole(JButton button) {
            this.button = button;
        }

        @Override
        public void run() {
            long UpTime = 1000 + random.nextInt(4000);
            while (flag && (!Thread.currentThread().isInterrupted())) {
                if (button.getText().equals(OFF_STRING)) {
                    try {
                        Thread.sleep(random.nextInt(3000));
                    } catch (InterruptedException interruptedException) {
                        button.setText(OFF_STRING);
                        button.setBackground(OFF_COLOR);
                        break;
                    }
                    button.setText(ON_STRING);
                    button.setBackground(ON_COLOR);
                    try {
                        Thread.sleep(UpTime);
                    } catch (InterruptedException e) {
                        button.setText(OFF_STRING);
                        button.setBackground(OFF_COLOR);
                        break;
                    }
                    button.setText(OFF_STRING);
                    button.setBackground(OFF_COLOR);

                }
            }


        }
    }

    public static void main(String[] args) {
        new Game(10);
    }

}

