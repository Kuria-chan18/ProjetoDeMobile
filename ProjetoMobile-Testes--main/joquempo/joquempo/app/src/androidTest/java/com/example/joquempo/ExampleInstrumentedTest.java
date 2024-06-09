package com.example.joquempo;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.MockitoJUnitRunner.Test;
//será que é o import correto?

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

    @InjectMocks
    MainActivity mainActivity;

    @Test
    public void testNavigateToSoloGame() {
       
        mainActivity.navigateToGameOptions();

        Intent expectedIntent = new Intent(mockContext, GameOptionsActivity.class);
        assertNotNull(expectedIntent);

        Mockito.doNothing().when(mockContext).startActivity(expectedIntent);

        mainActivity.onSoloClicked();

        Mockito.verify(mockContext).startActivity(expectedIntent);
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