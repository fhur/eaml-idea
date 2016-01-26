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

ColorLiteral   = "#" [0-9a-fA-F]{3,8}
IntegerLiteral = 0 | [1-9][0-9]*
StringLiteral  = \".*?\"
BoolLiteral    = (true)|(false)
DimenLiteral   = {IntegerLiteral}(dp|px|sp)

ResIden			= [:jletter:] [:jletterdigit:]*

%%

<YYINITIAL> {
	/* keywords */
	"color"           { return EamlTypes.COLOR; }
	"dimen"           { return EamlTypes.DIMEN; }
	"bool"            { return EamlTypes.BOOL; }
	"integer"         { return EamlTypes.INTEGER; }
	"string"          { return EamlTypes.STRING; }
	":"               { return EamlTypes.ASSIGNMENT; }
	";"               { return EamlTypes.LTERM; }
	"{"				  { return EamlTypes.L_BR; }
	"}"				  { return EamlTypes.R_BR; }
}

<YYINITIAL> {
	/* literals */
	{ColorLiteral}		{return EamlTypes.COLOR_LITERAL; }
	{DimenLiteral}		{return EamlTypes.DIMEN_LITERAL; }
	{BoolLiteral}		{return EamlTypes.BOOL_LITERAL; }
	{IntegerLiteral}	{return EamlTypes.INTEGER_LITERAL; }
	{StringLiteral}		{return EamlTypes.STRING_LITERAL; }
}

<YYINITIAL> {
	/* identifiers */
    {ResIden} 			  { return EamlTypes.RES_IDEN; }

	/* Skip */
	{WhiteSpace}      { return TokenType.WHITE_SPACE; }
}

/* error fallback */
[^]                              { return TokenType.BAD_CHARACTER; }