package eaml;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import eaml.psi.EamlTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.KEYWORD;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.OPERATION_SIGN;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.SEMICOLON;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.STATIC_FIELD;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author fernandohur
 */
public class EamlSyntaxHighlighter extends SyntaxHighlighterBase {

    /* keywords */
    static final TextAttributesKey COLOR = createTextAttributesKey("COLOR", KEYWORD);
    static final TextAttributesKey BOOL = createTextAttributesKey("BOOL", KEYWORD);
    static final TextAttributesKey DIMEN = createTextAttributesKey("DIMEN", KEYWORD);
    static final TextAttributesKey STRING = createTextAttributesKey("STRING", KEYWORD);
    static final TextAttributesKey INTEGER = createTextAttributesKey("INTEGER", KEYWORD);

    /* literals */
    static final TextAttributesKey COLOR_LITERAL = createTextAttributesKey("COLOR_LITERAL", DefaultLanguageHighlighterColors.STRING);
    static final TextAttributesKey BOOL_LITERAL = createTextAttributesKey("BOOL_LITERAL", DefaultLanguageHighlighterColors.STRING);
    static final TextAttributesKey DIMEN_LITERAL = createTextAttributesKey("DIMEN_LITERAL", DefaultLanguageHighlighterColors.STRING);
    static final TextAttributesKey STRING_LITERAL = createTextAttributesKey("STRING_LITERAL", DefaultLanguageHighlighterColors.STRING);
    static final TextAttributesKey INTEGER_LITERAL = createTextAttributesKey("INTEGER_LITERAL", DefaultLanguageHighlighterColors.STRING);

    /* Identifiers */
    static final TextAttributesKey COLOR_IDEN = createTextAttributesKey("COLOR_IDEN", STATIC_FIELD);

    static final TextAttributesKey ASSIGNMENT = createTextAttributesKey("ASSIGNMENT", OPERATION_SIGN);
    static final TextAttributesKey LTERM = createTextAttributesKey("LTERM", SEMICOLON);


    static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new EamlLexerAdapter();
    }

    public TextAttributesKey getTokenHighlightSingle(final IElementType tokenType) {
        if (tokenType.equals(EamlTypes.ASSIGNMENT)) {
            return ASSIGNMENT;
        } else if (tokenType.equals(EamlTypes.COLOR)) {
            return COLOR;
        } else if (tokenType.equals(EamlTypes.BOOL)) {
            return BOOL;
        } else if (tokenType.equals(EamlTypes.DIMEN)) {
            return DIMEN;
        } else if (tokenType.equals(EamlTypes.STRING)) {
            return STRING;
        } else if (tokenType.equals(EamlTypes.INTEGER)) {
            return INTEGER;

        } else if (tokenType.equals(EamlTypes.COLOR_LITERAL)) {
            return COLOR_LITERAL;
        } else if (tokenType.equals(EamlTypes.BOOL_LITERAL)) {
            return BOOL_LITERAL;
        } else if (tokenType.equals(EamlTypes.DIMEN_LITERAL)) {
            return DIMEN_LITERAL;
        } else if (tokenType.equals(EamlTypes.STRING_LITERAL)) {
            return STRING_LITERAL;
        } else if (tokenType.equals(EamlTypes.INTEGER_LITERAL)) {
            return INTEGER_LITERAL;

        } else if (tokenType.equals(EamlTypes.COLOR_IDEN)) {
            return COLOR_IDEN;

        } else if (tokenType.equals(EamlTypes.LTERM)) {
            return LTERM;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTER;
        }
        return null;
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(final IElementType tokenType) {
        TextAttributesKey textAttrKey = getTokenHighlightSingle(tokenType);
        if (textAttrKey == null) {
            return EMPTY_KEYS;
        } else {
            return new TextAttributesKey[] {textAttrKey};
        }
    }
}
