package eaml;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * @author fernandohur
 */
public class EamlColorSettingsPage implements ColorSettingsPage {

    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Identifier", EamlSyntaxHighlighter.COLOR_IDEN),
            new AttributesDescriptor("Assignment", EamlSyntaxHighlighter.ASSIGNMENT),
            new AttributesDescriptor("Color literal", EamlSyntaxHighlighter.COLOR_LITERAL),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return IconLoader.getIcon("/eaml/icons/icon.png");
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new EamlSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "color red: #f00;\n" +
                "color green: #00ff00;\n" +
                "color otherColor: #ff00ff12;\n" +
                "\n" +
                "color more_color: #0f1;\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "eaml";
    }
}
