package Calculator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton b10, b11, b12, b13, b14, b15;
	JButton b[] = new JButton[10];
	int i, r, num1, num2;
	JTextField res;
	char op;

	public Calculator() {
		super("Calulator");
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 4));
		for (int i = 0; i <= 9; i++) {
			b[i] = new JButton(i + "");
			p.add(b[i]);
			b[i].addActionListener(this);
		}
		b10 = new JButton("+");
		p.add(b10);
		b10.addActionListener(this);

		b11 = new JButton("-");
		p.add(b11);
		b11.addActionListener(this);

		b12 = new JButton("X");
		p.add(b12);
		b12.addActionListener(this);

		b13 = new JButton("÷");
		p.add(b13);
		b13.addActionListener(this);

		b14 = new JButton("=");
		p.add(b14);
		b14.addActionListener(this);

		b15 = new JButton("C");
		p.add(b15);
		b15.addActionListener(this);

		res = new JTextField(10);
		add(p, BorderLayout.CENTER);
		add(res, BorderLayout.NORTH);
		setVisible(true);
		setSize(400, 400);
	}

	public void actionPerformed(ActionEvent ae) {
		JButton press = (JButton) ae.getSource();
		if (press == b15) {
			r = num1 = num2 = 0;
			res.setText("");
		} else if (press == b14) {
			num2 = Integer.parseInt(res.getText());
			calc();
			res.setText("" + r);
		}

		else {
			boolean func = false;
			if (press == b10) {
				op = '+';
				func = true;
			}
			if (press == b11) {
				op = '-';
				func = true;
			}
			if (press == b12) {
				op = '*';
				func = true;
			}
			if (press == b13) {
				op = '/';
				func = true;
			}

			if (func == false) {
				for (i = 0; i < 10; i++) {
					if (press == b[i]) {
						String t = res.getText();
						t += i;
						res.setText(t);
					}
				}
			} else {
				num1 = Integer.parseInt(res.getText());
				res.setText("");
			}
		}
	}

	int calc() {
		switch (op) {
		case '+':
			r = num1 + num2;
			break;
		case '-':
			r = num1 - num2;
			break;
		case '*':
			r = num1 * num2;
			break;
		case '/':
			r = num1 / num2;
			break;

		}
		return 0;
	}

	public static void main(String arg[]) {
		new Calculator();
	}
}