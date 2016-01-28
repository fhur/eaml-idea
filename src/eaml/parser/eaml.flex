package eaml;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import eaml.psi.EamlTypes;
import com.intellij.psi.TokenType;

%%

%class EamlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
InputCharacter = [^\r\n]
LineComment    = "//" {InputCharacter}* {LineTerminator}?
ColorLiteral   = "#" [0-9a-fA-F]{3,8}
IntegerLiteral = 0 | [1-9][0-9]*
StringLiteral  = \".*?\"
BoolLiteral    = (true)|(false)
DimenLiteral   = {IntegerLiteral}(dp|sp|pt|px|mm|in)
NativePointer  = \@[a-zA-Z]\w*\/[a-zA-Z]\w*

ResIden			= [:jletter:] [:jletterdigit:]*

%%

<YYINITIAL> {
	/* keywords */
	"color"           { return EamlTypes.COLOR; }
	"dimen"           { return EamlTypes.DIMEN; }
	"bool"            { return EamlTypes.BOOL; }
	"integer"         { return EamlTypes.INTEGER; }
	"string"          { return EamlTypes.STRING; }
	"default"         { return EamlTypes.RES_IDEN; }
	"style"           { return EamlTypes.STYLE; }
	"mixin" 		  { return EamlTypes.MIXIN; }
	":"               { return EamlTypes.ASSIGNMENT; }
	"{"				  { return EamlTypes.L_BR; }
	"}"				  { return EamlTypes.R_BR; }
	"("				  { return EamlTypes.L_PR; }
    ")"				  { return EamlTypes.R_PR; }
	"null"  		  { return EamlTypes.NULL; }
	"." 			  { return EamlTypes.DOT; }
	"<" 			  { return EamlTypes.LT; }
	"&" 			  { return EamlTypes.AMP; }
	//"/" 			  { return EamlTypes.SLASH; }
}

<YYINITIAL> {
	/* literals */
	{ColorLiteral}		{ return EamlTypes.COLOR_LITERAL; }
	{DimenLiteral}		{ return EamlTypes.DIMEN_LITERAL; }
	{BoolLiteral}		{ return EamlTypes.BOOL_LITERAL; }
	{IntegerLiteral}	{ return EamlTypes.INTEGER_LITERAL; }
	{StringLiteral}		{ return EamlTypes.STRING_LITERAL; }

}

<YYINITIAL> {
	{LineComment} 		{ /* comments are ignored */ }

	/* identifiers */
    {ResIden} 			  { return EamlTypes.RES_IDEN; }

	/* Skip */
	{WhiteSpace}		{ return TokenType.WHITE_SPACE; }
}

/* error fallback */
[^]                              { return TokenType.BAD_CHARACTER; }