package eaml.psi;

import com.intellij.psi.tree.IElementType;
import eaml.EamlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fernandohur on 11/25/15.
 */
public class EamlElementType extends IElementType {
    public EamlElementType(@NotNull @NonNls final String debugName) {
        super(debugName, EamlLanguage.INSTANCE);
    }
}
