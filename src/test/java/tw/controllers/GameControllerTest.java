package tw.controllers;

import org.junit.Before;
import org.junit.Test;
import tw.commands.InputCommand;
import tw.core.Game;
import tw.views.GameView;

import static org.mockito.Mockito.*;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController;
    private Game mockGame;
    private GameView mockGameView;
    private InputCommand mockInputCommand;

    @Before
    public void setUp() throws Exception {
        mockGame = mock(Game.class);
        mockGameView = mock(GameView.class);
        mockInputCommand = mock(InputCommand.class);
        gameController = new GameController(mockGame, mockGameView);
    }

    @Test
    public void should_print_begin_message() throws Exception{
        gameController.beginGame();
        verify(mockGameView, times(1)).showBegin();
    }

    @Test
    public void should_continue_when_game_checkContinue_return_true() throws Exception{
        when(mockGame.checkCoutinue()).thenReturn(true).thenReturn(false);
        gameController.play(mockInputCommand);
        verify(mockGameView, times(1)).showGuessHistory(any());
    }

    @Test
    public void should_showGameStatus_when_checkContinue_return_false() throws Exception{
        when(mockGame.checkCoutinue()).thenReturn(false);
        gameController.play(mockInputCommand);
        verify(mockGameView, times(1)).showGameStatus(any());
    }
}