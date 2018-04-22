package tw.core.generator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.Answer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private AnswerGenerator generator;
    private RandomIntGenerator randomIntGenerator;
    @Before
    public void setUp() {
        randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        generator = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void should_generate_and_return_answer() throws Exception{
        int[] value = generator.generate().check(Answer.createAnswer("1 2 3 4")).getValue();
        Assert.assertEquals(4, value[0]);
        Assert.assertEquals(0, value[1]);
    }

    @Test
    public void should_generate_qualified_answer_when_call_generate_method() {

    }

    @Test
    public void should_throw_OutOfRangeAnswerException_when_answer_string_not_qualified() {

    }
}

