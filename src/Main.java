import controller.GameController;
import model.Chessboard;
import model.changshu;
import view.ChessGameFrame;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);

            Chessboard board=new Chessboard();
            GameController gameController = new GameController(mainFrame.getChessboardComponent(), board);
            mainFrame.setGameController(gameController);
            board.setGameController(gameController);
            gameController.board=board;
            gameController.frame=mainFrame;
            mainFrame.setVisible(true);
        });
        JFrame frame = new JFrame("turns");
        frame.setLayout(new FlowLayout()); // 设置布局管理器为 FlowLayout
        frame.setSize(400, 200);
        JLabel label = new JLabel("turns");

        JButton red = new JButton("red's turn");
        JButton blue = new JButton("blue's turn");
        frame.add(red);
        frame.add(blue);
        frame.add(label);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 模拟实时更新变量的过程
        while (true) {
            // 更新变量
            label.setText("turns: " + (changshu.turn));
            // 休眠一段时间，以模拟实时更新
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (changshu.turn % 2 == 1) {
                blue.setVisible(true);
                red.setVisible(false);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(changshu.turn%2 == 0)
            {
                blue.setVisible(false);
                red.setVisible(true);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
