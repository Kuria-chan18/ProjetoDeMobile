package com.example.joquempo;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.MockitoJUnitRunner.Test;



/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.joquempo", appContext.getPackageName());
    }

@RunWith(MockitoJUnitRunner.class)
public class MainActivityTest {

    @Mock
    Context mockContext;

    @Mock
    ImageView imageResultado;

    @Mock
    TextView textResultado;

    @InjectMocks
    MainActivity mainActivity;

    @Before
    public void setUp() {
        mainActivity = new MainActivity();
        mainActivity.imageResultado = imageResultado;
        mainActivity.textResultado = textResultado;
    }

    @Test
    public void testNavigateToSoloGame() {
        mainActivity.navigateToGameOptions();

        Intent expectedIntent = new Intent(mockContext, GameOptionsActivity.class);
        assertNotNull(expectedIntent);

        Mockito.doNothing().when(mockContext).startActivity(expectedIntent);

        mainActivity.onSoloClicked();

        Mockito.verify(mockContext).startActivity(expectedIntent);
    }

    @Test
    public void testOpcaoSelecionadaPedra() {
        mainActivity.opcaoSelecionada("pedra");

        assertNotNull(mainActivity.imageResultado);
        assertNotNull(mainActivity.textResultado);

        verify(imageResultado).setImageResource(Mockito.anyInt());

        String opcaoApp = mainActivity.getOpcaoApp();

        if ((opcaoApp.equals("tesoura") && "pedra".equals("papel")) ||
            (opcaoApp.equals("papel") && "pedra".equals("pedra")) ||
            (opcaoApp.equals("pedra") && "pedra".equals("tesoura"))) {
            verify(textResultado).setText("Você perdeu :( ");
        } else if (
            ("pedra".equals("tesoura") && opcaoApp.equals("papel")) ||
            ("pedra".equals("papel") && opcaoApp.equals("pedra")) ||
            ("pedra".equals("pedra") && opcaoApp.equals("tesoura"))) {
            verify(textResultado).setText("Você ganhou! :D ");
        } else {
            verify(textResultado).setText("Empatamos ;)");
        }
    }

    @Test
    public void testOpcaoSelecionadaPapel() {
        mainActivity.opcaoSelecionada("papel");

        assertNotNull(mainActivity.imageResultado);
        assertNotNull(mainActivity.textResultado);

        verify(imageResultado).setImageResource(Mockito.anyInt());

        String opcaoApp = mainActivity.getOpcaoApp();

        if ((opcaoApp.equals("tesoura") && "papel".equals("papel")) ||
            (opcaoApp.equals("papel") && "papel".equals("pedra")) ||
            (opcaoApp.equals("pedra") && "papel".equals("tesoura"))) {
            verify(textResultado).setText("Você perdeu :( ");
        } else if (
            ("papel".equals("tesoura") && opcaoApp.equals("papel")) ||
            ("papel".equals("papel") && opcaoApp.equals("pedra")) ||
            ("papel".equals("pedra") && opcaoApp.equals("tesoura"))) {
            verify(textResultado).setText("Você ganhou! :D ");
        } else {
            verify(textResultado).setText("Empatamos ;)");
        }
    }

    @Test
    public void testOpcaoSelecionadaTesoura() {
        mainActivity.opcaoSelecionada("tesoura");

        assertNotNull(mainActivity.imageResultado);
        assertNotNull(mainActivity.textResultado);

        verify(imageResultado).setImageResource(Mockito.anyInt());

        String opcaoApp = mainActivity.getOpcaoApp();

        if ((opcaoApp.equals("tesoura") && "tesoura".equals("papel")) ||
            (opcaoApp.equals("papel") && "tesoura".equals("pedra")) ||
            (opcaoApp.equals("pedra") && "tesoura".equals("tesoura"))) {
            verify(textResultado).setText("Você perdeu :( ");
        } else if (
            ("tesoura".equals("tesoura") && opcaoApp.equals("papel")) ||
            ("tesoura".equals("papel") && opcaoApp.equals("pedra")) ||
            ("tesoura".equals("pedra") && opcaoApp.equals("tesoura"))) {
            verify(textResultado).setText("Você ganhou! :D ");
        } else {
            verify(textResultado).setText("Empatamos ;)");
        }
    }
}


@RunWith(MockitoJUnitRunner.class)
public class Tela2ActivityTest {

    @Mock
    Context mockContext;

    @InjectMocks
    MainActivity mainActivity;

    @Test
    public void testNavigateToMultiplayerGame() {
       
        mainActivity.navigateToGameOptions();

        Intent expectedIntent = new Intent(mockContext, GameOptionsActivity.class);
        assertNotNull(expectedIntent);

        Mockito.doNothing().when(mockContext).startActivity(expectedIntent);

        mainActivity.onMultiplayerClicked();

        Mockito.verify(mockContext).startActivity(expectedIntent);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class MenuActivityTest {

    @Mock
    Context mockContext;

    @InjectMocks
    LoginActivity loginActivity;

    @Test
    public void testValidLogin() {
     
        loginActivity.usernameEditText.setText("user_valid");
        loginActivity.passwordEditText.setText("pass_valid");

        loginActivity.onLoginClicked();

        Mockito.verify(loginActivity).authenticate("user_valid", "pass_valid");
    }

    @Test
    public void testInvalidUsernameLogin() {

        loginActivity.usernameEditText.setText("user_invalid");
        loginActivity.passwordEditText.setText("pass_valid");

        loginActivity.onLoginClicked();

        Mockito.verify(loginActivity).authenticate("user_invalid", "pass_valid");
    }

    @Test
    public void testInvalidPasswordLogin() {
      
        loginActivity.usernameEditText.setText("user_valid");
        loginActivity.passwordEditText.setText("pass_invalid");

        loginActivity.onLoginClicked();

        Mockito.verify(loginActivity).authenticate("user_valid", "pass_invalid");
    }

    @Test
    public void testEmptyFieldsLogin() {
     
        loginActivity.usernameEditText.setText("");
        loginActivity.passwordEditText.setText("");

        loginActivity.onLoginClicked();

        Mockito.verify(loginActivity).showErrorMessage("Campos obrigatórios não podem estar em branco");
    }
}

@RunWith(MockitoJUnitRunner.class)
public class RankingTest {

    @Mock
    Context mockContext;

    @InjectMocks
    RankingActivity rankingActivity;

    @Test
    public void testViewRanking() {
      
        rankingActivity.navigateToRanking();

        List<RankingItem> rankingItems = rankingActivity.getRankingItems();
        assertNotNull(rankingItems);
        assertFalse(rankingItems.isEmpty());
    }
}

@RunWith(MockitoJUnitRunner.class)
public class SettingsActivityTest {

    @Mock
    Context mockContext;

    @InjectMocks
    SettingsActivity settingsActivity;

    @Test
    public void testAccessSettings() {
     
        settingsActivity.navigateToSettings();

        List<SettingItem> settingsItems = settingsActivity.getSettingsItems();
        assertNotNull(settingsItems);
        assertFalse(settingsItems.isEmpty());
    }

    @Test
    public void testModifySettings() {
       
        settingsActivity.modifySetting("volume", 50);

        int volume = settingsActivity.getSetting("volume");
        assertEquals(50, volume);
    }
}

@RunWith(MockitoJUnitRunner.class)
public class ProfileActivityTest {

    @Mock
    Context mockContext;

    @InjectMocks
    ProfileActivity profileActivity;

    @Test
    public void testAccessProfile() {
 
        profileActivity.navigateToProfile();

        UserProfile userProfile = profileActivity.getUserProfile();
        assertNotNull(userProfile);
    }

    @Test
    public void testModifyProfile() {

        profileActivity.modifyProfile("username", "new_username");

        String username = profileActivity.getProfileDetail("username");
        assertEquals("new_username", username);
    }

}

}