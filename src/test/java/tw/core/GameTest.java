package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;
import tw.core.model.Record;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private static final String FAIL = "fail";
    private static final String CONTINUE = "continue";
    private AnswerGenerator mockAnswerGenerator;
    private Answer mockCorrectAnswer;
    private Game game;
    private Record mockRecord;
    private Answer mockInputAnswer;

    @Before
    public void setUp() throws Exception {
        mockAnswerGenerator = mock(AnswerGenerator.class);
        mockCorrectAnswer = mock(Answer.class);

        when(mockAnswerGenerator.generate()).thenReturn(mockCorrectAnswer);

        game = new Game(mockAnswerGenerator);
        mockRecord = mock(Record.class);
        when(mockCorrectAnswer.check(any())).thenReturn(mockRecord);
        when(mockRecord.getValue()).thenReturn(new int[]{2, 1});

        mockInputAnswer = mock(Answer.class);
    }

    @Test
    public void should_return_result_of_2A1B_when_result_match_2_right_and_1_wrong() throws Exception{
        GuessResult guessResult = game.guess(mockInputAnswer);
        Assert.assertEquals("2A1B", guessResult.getResult());
        Assert.assertEquals(mockInputAnswer, guessResult.getInputAnswer());
    }

    @Test
    public void should_return_fail_when_guess_failure_count_greater_or_equal_to_MAX_TIMES() {
        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(CONTINUE, game.checkStatus());
            game.guess(mockInputAnswer);
        }
        Assert.assertEquals(FAIL, game.checkStatus());
    }

    @Test
    public void should_return_success_when_guess_success_and_count_less_than_MAX_TIMES() {
        game.guess(mockInputAnswer);
        Assert.assertEquals(CONTINUE, game.checkStatus());

        when(mockRecord.getValue()).thenReturn(new int[]{4, 0});

        game.guess(mockInputAnswer);
        Assert.assertEquals("success", game.checkStatus());
    }

    @Test
    public void should_return_continue_when() {

    }
}
