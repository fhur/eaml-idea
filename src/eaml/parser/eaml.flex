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

ColorIden       = [:jletter:] [:jletterdigit:]*
ConfigIden      = [:jletter:] [:jletterdigit:]*

%%

<YYINITIAL> {
	/* keywords */
	"color"           { System.out.println("matched color"); return EamlTypes.COLOR; }
	"dimen"           { return EamlTypes.DIMEN; }
	"bool"            { return EamlTypes.BOOL; }
	"integer"         { return EamlTypes.INTEGER; }
	"string"          { return EamlTypes.STRING; }
	":"               { System.out.println("matched :"); return EamlTypes.ASSIGNMENT; }
	";"               { System.out.println("matched ;"); return EamlTypes.LTERM; }
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
    {ColorIden} 			  { System.out.println("matched ColorIden ;"); return EamlTypes.COLOR_IDEN; }

	/* Skip */
	{WhiteSpace}      { System.out.println("matched whitespace"); }
}

/* error fallback */
[^]                              { return TokenType.BAD_CHARACTER; }