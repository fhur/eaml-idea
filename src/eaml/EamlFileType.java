package eaml;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by fernandohur on 11/24/15.
 */
public class EamlFileType extends LanguageFileType {


    public static final EamlFileType INSTANCE = new EamlFileType();

    public EamlFileType() {
        super(EamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "eaml";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Expressive android styles";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "eaml";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/eaml/icons/icon.png");
    }
}
