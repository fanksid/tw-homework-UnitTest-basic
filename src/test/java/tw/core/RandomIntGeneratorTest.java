package tw.core;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {

    RandomIntGenerator generator;

    @Before
    public void setUp() throws Exception {
        generator = new RandomIntGenerator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_digitmax_less_than_numbersOfNeed() {
        generator.generateNums(3, 4);
    }

    @Test
    public void generateNumsTest() {
        int digitmax = 8;
        int numbersOfNeed = 5;

        String[] strNums = generator.generateNums(digitmax, numbersOfNeed).split(" ");

        Assert.assertEquals(numbersOfNeed, strNums.length);

        eachElementLessThanDigitMax(digitmax, strNums);
    }

    private void eachElementLessThanDigitMax(int digitmax, String[] strNums) {
        for (String elem : strNums) {
            int num = Integer.parseInt(elem);
            Assert.assertTrue(num < digitmax);
        }
    }
}