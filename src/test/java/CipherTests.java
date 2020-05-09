import org.junit.Test;
import edu.wpi.cs3733.entity.*;

import static org.junit.Assert.assertEquals;

/**
 * Tests for your cipher functions; make sure your code works!
 * Test-driven development is a good idea here.
 */
public class CipherTests {
    @Test
    public void TestLowerCaseCaesar() {
        CaesarCipher c = new CaesarCipher();
        c.setText("asdf");
        assertEquals("zhwu", c.getText());
    }

    @Test
    public void TestUpperCaseCaesar() {
        CaesarCipher c = new CaesarCipher();
        c.setText("HJKL");
        assertEquals("SQPO", c.getText());
    }

    @Test
    public void TestPunctCaesar() {
        CaesarCipher c = new CaesarCipher();
        c.setText(",.! ?");
        assertEquals(",.! ?", c.getText());
    }

    @Test
    public void TestInvalidPunctCaesar() {
        CaesarCipher c = new CaesarCipher();
        c.setText("ab:");
        assertEquals("", c.getText());
    }

    @Test
    public void TestInvalidSymbolCaesar() {
        CaesarCipher c = new CaesarCipher();
        c.setText("ab$");
        assertEquals("", c.getText());
    }

    @Test
    public void TestInvalidNumCaesar() {
        CaesarCipher c = new CaesarCipher();
        c.setText("ab1");
        assertEquals("", c.getText());
    }

    @Test
    public void TestInvalidLengthCaesar() {
        CaesarCipher c = new CaesarCipher();
        String s = "";
        for(int i =  0; i < 150; i++) {
            s += "a";
        }
        c.setText(s);
        assertEquals("", c.getText());
    }

    @Test
    public void TestLowerCaseElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText("asdf");
        assertEquals("01190406", e.getText());
    }

    @Test
    public void TestUpperCaseElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText("HJKL");
        assertEquals("08101112", e.getText());
    }

    @Test
    public void TestPunctElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText(",.!? ");
        assertEquals(",.!?S", e.getText());
    }

    @Test
    public void TestZeroElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText("a0b");
        assertEquals("01_02", e.getText());
    }

    @Test
    public void TestNumsElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText("123456789");
        assertEquals("abcdefghi", e.getText());
    }

    @Test
    public void TestInvalidLengthElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        String s = "";
        for(int i =  0; i < 150; i++) {
            s += "a";
        }
        e.setText(s);
        assertEquals(280, e.getText().length());
    }

    @Test
    public void TestInvalidPunctElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText("ab:");
        assertEquals("", e.getText());
    }

    @Test
    public void TestInvalidSymbolElbonian() {
        ElbonianCipher e = new ElbonianCipher();
        e.setText("ab$");
        assertEquals("", e.getText());
    }


}
