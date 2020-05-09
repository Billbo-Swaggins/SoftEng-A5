import edu.wpi.cs3733.CipherController;
import edu.wpi.cs3733.entity.CaesarCipher;
import edu.wpi.cs3733.entity.ElbonianCipher;
import edu.wpi.cs3733.entity.Message;
import javafx.scene.control.TextField;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Tests for your observer pattern; make sure your code works!
 * Test-driven development is a good idea here.
 */
public class ObserverTests {
    @Test
    public void TestCaesarObserver() {
      Message m = new Message();
      CaesarCipher c = new CaesarCipher();
      m.register(c);
      m.setText("asdf");
      m.notifyObservers();
      assertEquals("zhwu", c.getText());
    }

    @Test
    public void TestElbonianObserver() {
        Message m = new Message();
        ElbonianCipher e = new ElbonianCipher();
        m.register(e);
        m.setText("asdf");
        m.notifyObservers();
        assertEquals("01190406", e.getText());
    }

    @Test
    public void TestNotRegisterObserver() {
        Message m = new Message();
        CaesarCipher c = new CaesarCipher();
        m.setText("asdf");
        m.notifyObservers();
        assertNotEquals("zhwu", c.getText());
    }
}
