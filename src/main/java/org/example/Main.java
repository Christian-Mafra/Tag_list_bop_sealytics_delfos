package org.example;
//Christian Mafra
//Atualização Sitops

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static Robot robo;
    static {
        try {
            robo = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws AWTException, IOException, UnsupportedFlavorException{

        int x = 421;
        while (x > 0){
            robo.mouseMove(100, 200);                         //Mover mouse para barra de busca do SMART
            robo.delay(500);
            Click(2);
            Colar();
            robo.delay(4500);

            robo.mouseMove(217,290);                          //Mover mouse para início do campo descrição
            robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);            //Pressionar butão direito do mouse
            robo.mouseMove(320, 290);                         //Arrastar mouse
            robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);          //Soltar botão direito
            robo.delay(2000);
            Copiar();                                               //Copiando conteúdo
            robo.mouseMove(900, 300);                         //Clicando no excel
            Click(1);
            robo.keyPress(KeyEvent.VK_RIGHT);                       //Selecionando célula à direita
            Colar();                                                //colando
            robo.mouseMove(233,455);                          //Mover mouse para início do campo tag_opc
            Click(1);

            robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);            //Pressionar butão direito do mouse
            robo.mouseMove(350, 455);                        //Arrastar mouse
            robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);          //Soltar botão direito
            robo.delay(2000);
            Copiar();                                               //Copiando conteúdo
            robo.mouseMove(900, 300);                         //Clicando no excel
            Click(1);
            robo.keyPress(KeyEvent.VK_RIGHT);                       //Selecionando célula à direita
            Colar();                                                //colando

            //voltando
            robo.keyPress(KeyEvent.VK_LEFT);
            robo.keyRelease(KeyEvent.VK_LEFT);
            robo.keyPress(KeyEvent.VK_LEFT);
            robo.keyRelease(KeyEvent.VK_LEFT);
            robo.keyPress(KeyEvent.VK_DOWN);
            Copiar();
            robo.mouseMove(620, 290);
            Click(1);

            x = x-1;

        }

    }

    private static void Copiar() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_C);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_C);
        robo.delay(500);
    }
    private static void Colar() {
        robo.keyPress(KeyEvent.VK_CONTROL);
        robo.keyPress(KeyEvent.VK_V);
        robo.keyRelease(KeyEvent.VK_CONTROL);
        robo.keyRelease(KeyEvent.VK_V);
        robo.delay(500);
    }
    public static void Click(int i){
        while (i != 0){
            robo.delay(10);
            robo.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robo.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
            --i;
        }
    }
}