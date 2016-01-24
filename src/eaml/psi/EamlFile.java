package eaml.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import eaml.EamlFileType;
import eaml.EamlLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author fernandohur
 */
public class EamlFile extends PsiFileBase {

    public EamlFile(@NotNull final FileViewProvider viewProvider) {
        super(viewProvider, EamlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return EamlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "eaml file";
    }

    @Nullable
    @Override
    public Icon getIcon(final int flags) {
        return super.getIcon(flags);
    }
}
