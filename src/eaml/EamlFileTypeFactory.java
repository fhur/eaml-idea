package eaml;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * Created by fernandohur on 11/24/15.
 */
public class EamlFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull final FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(EamlFileType.INSTANCE, "eaml");
    }
}
