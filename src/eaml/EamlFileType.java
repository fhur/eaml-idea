package eaml;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.module.ResourceFileUtil;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.net.URL;

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
        // TODO add a decent icon
        return null;
    }
}
