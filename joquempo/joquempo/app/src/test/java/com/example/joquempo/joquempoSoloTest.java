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

    public class joquempoSoloTest {
        @Test
        public void testEmpate() {
           joquempoSolo jogo = new joquempoSolo();
            assertEquals("Empate", jogo.jogar(PedraPapelTesoura.Jogada.PEDRA, PedraPapelTesoura.Jogada.PEDRA));
            assertEquals("Empate", jogo.jogar(PedraPapelTesoura.Jogada.PAPEL, PedraPapelTesoura.Jogada.PAPEL));
            assertEquals("Empate", jogo.jogar(PedraPapelTesoura.Jogada.TESOURA, PedraPapelTesoura.Jogada.TESOURA));
        }
    
        @Test
        public void testJogadorVence() {
            joquempoSolo jogo = new joquempoSolo();
            assertEquals("Jogador vence", jogo.jogar(PedraPapelTesoura.Jogada.PEDRA, PedraPapelTesoura.Jogada.TESOURA));
            assertEquals("Jogador vence", jogo.jogar(PedraPapelTesoura.Jogada.PAPEL, PedraPapelTesoura.Jogada.PEDRA));
            assertEquals("Jogador vence", jogo.jogar(PedraPapelTesoura.Jogada.TESOURA, PedraPapelTesoura.Jogada.PAPEL));
        }
    
        @Test
        public void testComputadorVence() {
           joquempoSolo jogo = new joquempoSolo();
            assertEquals("Máquina vence", jogo.jogar(PedraPapelTesoura.Jogada.TESOURA, PedraPapelTesoura.Jogada.PEDRA));
            assertEquals("Máquina vence", jogo.jogar(PedraPapelTesoura.Jogada.PEDRA, PedraPapelTesoura.Jogada.PAPEL));
            assertEquals("Máquina vence", jogo.jogar(PedraPapelTesoura.Jogada.PAPEL, PedraPapelTesoura.Jogada.TESOURA));
        }

}