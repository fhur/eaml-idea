package eaml;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import eaml.psi.EamlTypes;
import org.codehaus.groovy.antlr.java.JavaTokenTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.BRACKETS;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.KEYWORD;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.OPERATION_SIGN;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.SEMICOLON;
import static com.intellij.openapi.editor.DefaultLanguageHighlighterColors.STATIC_FIELD;
import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * @author fernandohur
 */
public class EamlSyntaxHighlighter extends SyntaxHighlighterBase {

    static final TextAttributesKey[] KEYWORDS = new TextAttributesKey[] { DefaultLanguageHighlighterColors.KEYWORD };
    static final TextAttributesKey[] LITERALS = new TextAttributesKey[] { DefaultLanguageHighlighterColors.STRING };
    static final TextAttributesKey[] ASSIGNMENT_KEYS = new TextAttributesKey[] { DefaultLanguageHighlighterColors.OPERATION_SIGN };
    static final TextAttributesKey[] SEMICOLONS = new TextAttributesKey[] { DefaultLanguageHighlighterColors.SEMICOLON };
    static final TextAttributesKey[] BRACKETS = new TextAttributesKey[] { DefaultLanguageHighlighterColors.BRACKETS };

    static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    static final TextAttributesKey[] BAD_CHARACTERS = new TextAttributesKey[] { BAD_CHARACTER };

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new EamlLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(final IElementType tokenType) {
        // keywords
        if (in(tokenType, EamlTypes.COLOR, EamlTypes.BOOL, EamlTypes.INTEGER, EamlTypes.DIMEN, EamlTypes.STRING)) {
            return KEYWORDS;
        }
        // literals
        else if (in(tokenType, EamlTypes.COLOR_LITERAL, EamlTypes.BOOL_LITERAL, EamlTypes.INTEGER_LITERAL,
                EamlTypes.DIMEN_LITERAL, EamlTypes.STRING_LITERAL)) {
            return LITERALS;
        }
        else if (in(tokenType, EamlTypes.L_BR, EamlTypes.R_BR)){
            return BRACKETS;
        }
        else if (tokenType.equals(EamlTypes.ASSIGNMENT)) {
            return ASSIGNMENT_KEYS;
        }
        else if (tokenType.equals(EamlTypes.LTERM)) {
            return SEMICOLONS;
        }
        else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHARACTERS;
        }

        return EMPTY_KEYS;
    }

    private boolean in(IElementType tokenType, IElementType... types) {
        for (IElementType eamlType : types) {
            if(tokenType.equals(eamlType)){
                return true;
            }
        }
        return false;
    }
}
