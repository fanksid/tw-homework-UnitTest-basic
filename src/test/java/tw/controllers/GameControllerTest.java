package tw.controllers;

import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.GuessNumberModule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.google.inject.Guice.createInjector;

/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private GameController gameController;

    @Before
    public void setUp() throws Exception {
        Injector injector = createInjector(new GuessNumberModule());
        gameController = injector.getInstance(GameController.class);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_begin_message() throws Exception{
        gameController.beginGame();
        String result = "------Guess Number Game, You have 6 chances to guess!  ------\n";
        Assert.assertEquals(systemOut(), result);
    }

    private String systemOut() {
        return outContent.toString();
    }

//     TODO: 考虑对play的测试
//    1. 猜6次都没猜对
//    2. 猜1次就对
//    3. 第6次猜对
//    4. 第5次猜对
//    问题在于无法手动设置正确答案

}