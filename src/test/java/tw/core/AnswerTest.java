package tw.core;

import org.junit.Assert;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.model.Record;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_exception_when_have_duplicate_element() throws Exception{
        Answer answer = Answer.createAnswer("1 2 3 3");
        answer.validate();
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throw_exception_when_element_greater_than_9() throws Exception{
        Answer answer = Answer.createAnswer("1 2 3 10");
        answer.validate();
    }

    @Test
    public void should_pass_validate_when_no_duplicate_element_and_all_element_less_than_10() throws Exception{
        Answer answer1 = Answer.createAnswer("1 2 3 4");
        answer1.validate();

        Answer answer2 = Answer.createAnswer("0 2 3 9");
        answer2.validate();

        Answer answer3 = Answer.createAnswer("1 2 3 4 5 6");
        answer3.validate();
    }

    @Test
    public void should_return_0A0B_when_all_digit_not_included() {
        answerCheck("1 2 3 4", "5 6 7 8", 0, 0);
    }

    @Test
    public void should_return_correct_count_of_A_and_B() {
        answerCheck("1 2 3 4", "1 6 7 8", 1, 0);
        answerCheck("1 2 3 4", "5 1 7 8", 0, 1);
        answerCheck("1 2 3 4", "1 2 3 4", 4, 0);
        answerCheck("1 2 3 4", "4 3 2 1", 0, 4);
        answerCheck("1 2 3 4", "1 2 5 6", 2, 0);
        answerCheck("1 2 3 4", "3 4 5 6", 0, 2);
        answerCheck("1 2 3 4", "1 4 5 6", 1, 1);
    }

    private void answerCheck(String correctAnswer, String guessAnswer, int expectA, int expectB) {
        Answer answer = Answer.createAnswer(correctAnswer);
        Record record = answer.check(Answer.createAnswer(guessAnswer));
        int[] value = record.getValue();
        Assert.assertEquals(expectA, value[0]);
        Assert.assertEquals(expectB, value[1]);
    }
}