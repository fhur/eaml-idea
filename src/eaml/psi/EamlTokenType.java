package eaml.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import eaml.EamlLanguage;
import eaml.EamlLexerAdapter;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fernandohur on 11/25/15.
 */
public class EamlTokenType extends IElementType {

    private String debugName;

    public EamlTokenType(@NotNull @NonNls final String debugName) {
        super(debugName, EamlLanguage.INSTANCE);
        this.debugName = debugName;
    }

    @Override
    public String toString() {
        return debugName;
    }
}
