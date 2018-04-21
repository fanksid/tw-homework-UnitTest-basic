package tw.core.generator;

import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    AnswerGenerator generator;
    RandomIntGenerator randomIntGenerator;
    @Before
    public void setUp() throws Exception {
        randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        generator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void should_generate_and_return_answer() throws Exception{
        generator.generate();
    }
}

