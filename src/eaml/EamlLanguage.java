package eaml;

import com.intellij.lang.Language;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by fernandohur on 11/24/15.
 */
public class EamlLanguage extends Language {

    public static EamlLanguage INSTANCE = new EamlLanguage();

    public EamlLanguage() {
        super("eaml");
    }
}
