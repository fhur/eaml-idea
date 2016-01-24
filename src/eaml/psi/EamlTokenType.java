package eaml.psi;

import com.intellij.psi.tree.IElementType;
import eaml.EamlLanguage;
import eaml.EamlLexerAdapter;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fernandohur on 11/25/15.
 */
public class EamlTokenType extends IElementType {

    public EamlTokenType(@NotNull @NonNls final String debugName) {
        super(debugName, EamlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "EamlTokenType."+super.toString();
    }
}
