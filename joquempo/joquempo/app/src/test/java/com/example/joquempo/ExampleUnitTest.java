package com.example.joquempo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */


//public class ExampleUnitTest {
   // @Test
    //public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);
    //}

    public class PedraPapelTesouraTest {
        @Test
        public void testEmpate() {
            PedraPapelTesoura jogo = new PedraPapelTesoura();
            assertEquals("Empate", jogo.jogar(PedraPapelTesoura.Jogada.PEDRA, PedraPapelTesoura.Jogada.PEDRA));
            assertEquals("Empate", jogo.jogar(PedraPapelTesoura.Jogada.PAPEL, PedraPapelTesoura.Jogada.PAPEL));
            assertEquals("Empate", jogo.jogar(PedraPapelTesoura.Jogada.TESOURA, PedraPapelTesoura.Jogada.TESOURA));
        }
    
        @Test
        public void testJogadorVence() {
            PedraPapelTesoura jogo = new PedraPapelTesoura();
            assertEquals("Jogador vence", jogo.jogar(PedraPapelTesoura.Jogada.PEDRA, PedraPapelTesoura.Jogada.TESOURA));
            assertEquals("Jogador vence", jogo.jogar(PedraPapelTesoura.Jogada.PAPEL, PedraPapelTesoura.Jogada.PEDRA));
            assertEquals("Jogador vence", jogo.jogar(PedraPapelTesoura.Jogada.TESOURA, PedraPapelTesoura.Jogada.PAPEL));
        }
    
        @Test
        public void testComputadorVence() {
            PedraPapelTesoura jogo = new PedraPapelTesoura();
            assertEquals("Computador vence", jogo.jogar(PedraPapelTesoura.Jogada.TESOURA, PedraPapelTesoura.Jogada.PEDRA));
            assertEquals("Computador vence", jogo.jogar(PedraPapelTesoura.Jogada.PEDRA, PedraPapelTesoura.Jogada.PAPEL));
            assertEquals("Computador vence", jogo.jogar(PedraPapelTesoura.Jogada.PAPEL, PedraPapelTesoura.Jogada.TESOURA));
        }

}

