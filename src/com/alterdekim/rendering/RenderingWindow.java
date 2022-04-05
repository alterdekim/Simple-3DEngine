package com.alterdekim.rendering;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class RenderingWindow {

	private JFrame frmRendering;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RenderingWindow window = new RenderingWindow();
					window.frmRendering.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RenderingWindow() {
		initialize();
	}

	private void initialize() {
		frmRendering = new JFrame();
		frmRendering.setTitle("Rendering");
		frmRendering.setResizable(false);
		frmRendering.setBounds(100, 100, 400, 400);
		frmRendering.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Canvas panel = new Canvas();
		frmRendering.getContentPane().add(panel, BorderLayout.CENTER);
	}

}
