
import org.junit.Test;

/**
 *
 * @author Guilherme dos Santos Fujiyoshi
 */
public class JUnitTeste {

    @Test(expected=Exception.class)
    public static void checaValidatorString() throws Exception {
        throw new Exception();
    }
}
