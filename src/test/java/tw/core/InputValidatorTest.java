package tw.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    InputValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new InputValidator();
    }

    @Test
    public void should_return_false_when_numCount_not_equal() {
        Assert.assertFalse(validator.validate("1 2 3"));
    }

    @Test
    public void should_return_false_when_distinct_numCount_not_equal() {
        Assert.assertFalse(validator.validate("1 2 3 3"));
    }

    @Test
    public void should_return_false_when_num_greater_than_9() {
        Assert.assertFalse(validator.validate("1 2 3 10"));
    }

    @Test
    public void should_return_true_when_satisfy_all_constraint() {
        Assert.assertTrue(validator.validate("1 2 3 9"));
        Assert.assertTrue(validator.validate("4 2 3 1"));
        Assert.assertTrue(validator.validate("0 6 8 3"));
    }
}
