package eaml;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.FlexLexer;

import java.io.Reader;

/**
 * @author fernandohur
 */
public class EamlLexerAdapter extends FlexAdapter {

    public EamlLexerAdapter() {
        super(new EamlLexer((Reader) null));
    }
}
