/*******************************************************************************
 * Copyright (c) 2013 Nick Guletskii.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Nick Guletskii - initial API and implementation
 ******************************************************************************/

grammar TSLKGrammar;
body:
         (stmt SEMI)*
    ;
stmt:
    expr #NormalStmt
    | RETURN e=expr #ReturnStmt
    | BREAK #BreakStmt
    | CONTINUE #ContinueStmt
    | FOR initexpr = expr SEMI whileexpr=expr SEMI increxpr=expr DO forbody=body END #ForBlock
    | WHILE whileexpr=expr DO whilebody=body END #WhileBlock
    | IF ifexpr=expr THEN ifbody=body (ELSE IF elifexprs+=expr THEN elifbodies+=body)* (ELSE elsebody=body)? END #IfBlock
;
expr:
     l=expr o=POW r=expr #BinaryOperator
    | o=(NOT | LEN | MINUS) e=expr #UnaryOperator
    | l=expr o=(MUL | DIV | REM) r=expr #BinaryOperator
    | l=expr o=(PLUS | MINUS) r=expr #BinaryOperator
    | l=expr o=(LESSEQ| LESS | MOREEQ | MORE | NOTEQ | EQEQ) r=expr #BinaryOperator
    | l=expr o=OR r=expr #BinaryOperator
    | l=expr o=AND r=expr #BinaryOperator
    | FUNC LPAREN (args+=GENERAL_ID (COMMA args+=GENERAL_ID)*?)? RPAREN funcbody=body END #FuncBlock
    | TABLE (vals+=tablenode (COMMA vals+=tablenode)*)? END #TableBlock
    | LOCAL varid=GENERAL_ID o=EQ val=expr #LocalAssignExpr
    | varpath=path o=EQ val=expr #AssignExpr
    | varpath=path o=(PLUSEQ | MINUSEQ | MULEQ | DIVEQ | REM) val=expr #ModifyExpr
    | NUMBER #AtomNumber
    | STRING #AtomString
    | TRUE #AtomBooleanTrue
    | FALSE #AtomBooleanFalse
    | path #PathCall
    | LPAREN e=expr RPAREN #SubExpr;
tablenode:
   (key = (STRING|GENERAL_ID) COLON)? val=expr;
path:
         l=path DOT name=GENERAL_ID #StaticChildCall
         | l=path LBRACKET r=expr RBRACKET #DynamicChildCall
         | l=path (LPAREN (args+=expr (COMMA args+=expr)*?)? RPAREN) #FuncCall
         | name=GENERAL_ID #StaticChildCall
         | LBRACKET r=expr RBRACKET #DynamicChildCall
     ;
NUMBER: DIGIT+ '.' DIGIT+|
        DIGIT+
;
FUNC: <function_keyword>;
FOR: <for_keyword>;
WHILE: <while_keyword>;
IF: <if_keyword>;
ELSE: <else_keyword>;
THEN: <then_keyword>;
DO: <do_keyword>;
END: <end_keyword>;
OR: <or_keyword>;
AND: <and_keyword>;
LOCAL: <local_keyword>;
TABLE: <table_keyword>;
RETURN: <return_keyword>;
BREAK: <break_keyword>;
CONTINUE: <continue_keyword>;
TRUE: <true_keyword>;
FALSE: <false_keyword>;
PLUSEQ: <plus_equals_operator>;
MINUSEQ: <minus_equals_operator>;
MULEQ: <multiply_equals_operator>;
DIVEQ: <divide_equals_operator>;
REMEQ: <remainder_equals_operator>;
POWEQ: <exponentiate_equals_operator>;
LESSEQ: <less_or_equals_operator>;
LESS: <less_operator>;
MOREEQ: <more_or_equals_operator>;
MORE: <more_operator>;
EQEQ: <equals_equals_operator>;
EQ: <equals_operator>;
NOTEQ: <not_equals_operator>;
PLUS: <plus_operator>;
MINUS: <minus_operator>;
MUL: <multiply_operator>;
DIV: <divide_operator>;
REM: <remainder_operator>;
NOT: <not_operator>;
LEN: <length_operator>;
POW: <exponentiate_operator>;
DOT: <dot_operator>;
COMMA:<comma_operator>;
SEMI:<semicolon_operator>;
COLON:<colon_operator>;
LPAREN:<lparen>;
RPAREN:<rparen>;
LBRACKET:<lbracket>;
RBRACKET:<rbracket>;
LBRACE:<lbrace>;
RBRACE:<rbrace>;
STRING:'"' (ESC|~[\\\\"])* '"';
fragment ESC: '\\\\'('n' | 't' | 'u' HEXDIGIT HEXDIGIT HEXDIGIT HEXDIGIT);
fragment DIGIT:'0'..'9';
fragment HEXDIGIT:('0'..'9'|'a'..'f'|'A'..'F');
fragment XID_Start:('a'..'z'|'A'..'Z'|'_');
fragment XID_Continue:XID_Start|('1'..'9');
SLCOMMENT:  '//' .*? '\r'? '\n' -> skip;
MLCOMMENT:  '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip ;
GENERAL_ID: XID_Start XID_Continue*;
/*
fragment XID_Start:('\u0041'..'\u005A')
|(\'u0061'..'\u007A')
|(\'u00AA')
|(\'u00B5')
|(\'u00BA')
|(\'u00C0'..'\u00D6')
|(\'u00D8'..'\u00F6')
|(\'u00F8'..'\u01BA')
|(\'u01BB')
|(\'u01BC'..'\u01BF')
|(\'u01C0'..'\u01C3')
|(\'u01C4'..'\u0293')
|(\'u0294')
|(\'u0295'..'\u02AF')
|(\'u02B0'..'\u02C1')
|(\'u02C6'..'\u02D1')
|(\'u02E0'..'\u02E4')
|(\'u02EC')
|(\'u02EE')
|(\'u0370'..'\u0373')
|(\'u0374')
|(\'u0376'..'\u0377')
|(\'u037B'..'\u037D')
|(\'u0386')
|(\'u0388'..'\u038A')
|(\'u038C')
|(\'u038E'..'\u03A1')
|(\'u03A3'..'\u03F5')
|(\'u03F7'..'\u0481')
|(\'u048A'..'\u0527')
|(\'u0531'..'\u0556')
|(\'u0559')
|(\'u0561'..'\u0587')
|(\'u05D0'..'\u05EA')
|(\'u05F0'..'\u05F2')
|(\'u0620'..'\u063F')
|(\'u0640')
|(\'u0641'..'\u064A')
|(\'u066E'..'\u066F')
|(\'u0671'..'\u06D3')
|(\'u06D5')
|(\'u06E5'..'\u06E6')
|(\'u06EE'..'\u06EF')
|(\'u06FA'..'\u06FC')
|(\'u06FF')
|(\'u0710')
|(\'u0712'..'\u072F')
|(\'u074D'..'\u07A5')
|(\'u07B1')
|(\'u07CA'..'\u07EA')
|(\'u07F4'..'\u07F5')
|(\'u07FA')
|(\'u0800'..'\u0815')
|(\'u081A')
|(\'u0824')
|(\'u0828')
|(\'u0840'..'\u0858')
|(\'u08A0')
|(\'u08A2'..'\u08AC')
|(\'u0904'..'\u0939')
|(\'u093D')
|(\'u0950')
|(\'u0958'..'\u0961')
|(\'u0971')
|(\'u0972'..'\u0977')
|(\'u0979'..'\u097F')
|(\'u0985'..'\u098C')
|(\'u098F'..'\u0990')
|(\'u0993'..'\u09A8')
|(\'u09AA'..'\u09B0')
|(\'u09B2')
|(\'u09B6'..'\u09B9')
|(\'u09BD')
|(\'u09CE')
|(\'u09DC'..'\u09DD')
|(\'u09DF'..'\u09E1')
|(\'u09F0'..'\u09F1')
|(\'u0A05'..'\u0A0A')
|(\'u0A0F'..'\u0A10')
|(\'u0A13'..'\u0A28')
|(\'u0A2A'..'\u0A30')
|(\'u0A32'..'\u0A33')
|(\'u0A35'..'\u0A36')
|(\'u0A38'..'\u0A39')
|(\'u0A59'..'\u0A5C')
|(\'u0A5E')
|(\'u0A72'..'\u0A74')
|(\'u0A85'..'\u0A8D')
|(\'u0A8F'..'\u0A91')
|(\'u0A93'..'\u0AA8')
|(\'u0AAA'..'\u0AB0')
|(\'u0AB2'..'\u0AB3')
|(\'u0AB5'..'\u0AB9')
|(\'u0ABD')
|(\'u0AD0')
|(\'u0AE0'..'\u0AE1')
|(\'u0B05'..'\u0B0C')
|(\'u0B0F'..'\u0B10')
|(\'u0B13'..'\u0B28')
|(\'u0B2A'..'\u0B30')
|(\'u0B32'..'\u0B33')
|(\'u0B35'..'\u0B39')
|(\'u0B3D')
|(\'u0B5C'..'\u0B5D')
|(\'u0B5F'..'\u0B61')
|(\'u0B71')
|(\'u0B83')
|(\'u0B85'..'\u0B8A')
|(\'u0B8E'..'\u0B90')
|(\'u0B92'..'\u0B95')
|(\'u0B99'..'\u0B9A')
|(\'u0B9C')
|(\'u0B9E'..'\u0B9F')
|(\'u0BA3'..'\u0BA4')
|(\'u0BA8'..'\u0BAA')
|(\'u0BAE'..'\u0BB9')
|(\'u0BD0')
|(\'u0C05'..'\u0C0C')
|(\'u0C0E'..'\u0C10')
|(\'u0C12'..'\u0C28')
|(\'u0C2A'..'\u0C33')
|(\'u0C35'..'\u0C39')
|(\'u0C3D')
|(\'u0C58'..'\u0C59')
|(\'u0C60'..'\u0C61')
|(\'u0C85'..'\u0C8C')
|(\'u0C8E'..'\u0C90')
|(\'u0C92'..'\u0CA8')
|(\'u0CAA'..'\u0CB3')
|(\'u0CB5'..'\u0CB9')
|(\'u0CBD')
|(\'u0CDE')
|(\'u0CE0'..'\u0CE1')
|(\'u0CF1'..'\u0CF2')
|(\'u0D05'..'\u0D0C')
|(\'u0D0E'..'\u0D10')
|(\'u0D12'..'\u0D3A')
|(\'u0D3D')
|(\'u0D4E')
|(\'u0D60'..'\u0D61')
|(\'u0D7A'..'\u0D7F')
|(\'u0D85'..'\u0D96')
|(\'u0D9A'..'\u0DB1')
|(\'u0DB3'..'\u0DBB')
|(\'u0DBD')
|(\'u0DC0'..'\u0DC6')
|(\'u0E01'..'\u0E30')
|(\'u0E32')
|(\'u0E40'..'\u0E45')
|(\'u0E46')
|(\'u0E81'..'\u0E82')
|(\'u0E84')
|(\'u0E87'..'\u0E88')
|(\'u0E8A')
|(\'u0E8D')
|(\'u0E94'..'\u0E97')
|(\'u0E99'..'\u0E9F')
|(\'u0EA1'..'\u0EA3')
|(\'u0EA5')
|(\'u0EA7')
|(\'u0EAA'..'\u0EAB')
|(\'u0EAD'..'\u0EB0')
|(\'u0EB2')
|(\'u0EBD')
|(\'u0EC0'..'\u0EC4')
|(\'u0EC6')
|(\'u0EDC'..'\u0EDF')
|(\'u0F00')
|(\'u0F40'..'\u0F47')
|(\'u0F49'..'\u0F6C')
|(\'u0F88'..'\u0F8C')
|(\'u1000'..'\u102A')
|(\'u103F')
|(\'u1050'..'\u1055')
|(\'u105A'..'\u105D')
|(\'u1061')
|(\'u1065'..'\u1066')
|(\'u106E'..'\u1070')
|(\'u1075'..'\u1081')
|(\'u108E')
|(\'u10A0'..'\u10C5')
|(\'u10C7')
|(\'u10CD')
|(\'u10D0'..'\u10FA')
|(\'u10FC')
|(\'u10FD'..'\u1248')
|(\'u124A'..'\u124D')
|(\'u1250'..'\u1256')
|(\'u1258')
|(\'u125A'..'\u125D')
|(\'u1260'..'\u1288')
|(\'u128A'..'\u128D')
|(\'u1290'..'\u12B0')
|(\'u12B2'..'\u12B5')
|(\'u12B8'..'\u12BE')
|(\'u12C0')
|(\'u12C2'..'\u12C5')
|(\'u12C8'..'\u12D6')
|(\'u12D8'..'\u1310')
|(\'u1312'..'\u1315')
|(\'u1318'..'\u135A')
|(\'u1380'..'\u138F')
|(\'u13A0'..'\u13F4')
|(\'u1401'..'\u166C')
|(\'u166F'..'\u167F')
|(\'u1681'..'\u169A')
|(\'u16A0'..'\u16EA')
|(\'u16EE'..'\u16F0')
|(\'u1700'..'\u170C')
|(\'u170E'..'\u1711')
|(\'u1720'..'\u1731')
|(\'u1740'..'\u1751')
|(\'u1760'..'\u176C')
|(\'u176E'..'\u1770')
|(\'u1780'..'\u17B3')
|(\'u17D7')
|(\'u17DC')
|(\'u1820'..'\u1842')
|(\'u1843')
|(\'u1844'..'\u1877')
|(\'u1880'..'\u18A8')
|(\'u18AA')
|(\'u18B0'..'\u18F5')
|(\'u1900'..'\u191C')
|(\'u1950'..'\u196D')
|(\'u1970'..'\u1974')
|(\'u1980'..'\u19AB')
|(\'u19C1'..'\u19C7')
|(\'u1A00'..'\u1A16')
|(\'u1A20'..'\u1A54')
|(\'u1AA7')
|(\'u1B05'..'\u1B33')
|(\'u1B45'..'\u1B4B')
|(\'u1B83'..'\u1BA0')
|(\'u1BAE'..'\u1BAF')
|(\'u1BBA'..'\u1BE5')
|(\'u1C00'..'\u1C23')
|(\'u1C4D'..'\u1C4F')
|(\'u1C5A'..'\u1C77')
|(\'u1C78'..'\u1C7D')
|(\'u1CE9'..'\u1CEC')
|(\'u1CEE'..'\u1CF1')
|(\'u1CF5'..'\u1CF6')
|(\'u1D00'..'\u1D2B')
|(\'u1D2C'..'\u1D6A')
|(\'u1D6B'..'\u1D77')
|(\'u1D78')
|(\'u1D79'..'\u1D9A')
|(\'u1D9B'..'\u1DBF')
|(\'u1E00'..'\u1F15')
|(\'u1F18'..'\u1F1D')
|(\'u1F20'..'\u1F45')
|(\'u1F48'..'\u1F4D')
|(\'u1F50'..'\u1F57')
|(\'u1F59')
|(\'u1F5B')
|(\'u1F5D')
|(\'u1F5F'..'\u1F7D')
|(\'u1F80'..'\u1FB4')
|(\'u1FB6'..'\u1FBC')
|(\'u1FBE')
|(\'u1FC2'..'\u1FC4')
|(\'u1FC6'..'\u1FCC')
|(\'u1FD0'..'\u1FD3')
|(\'u1FD6'..'\u1FDB')
|(\'u1FE0'..'\u1FEC')
|(\'u1FF2'..'\u1FF4')
|(\'u1FF6'..'\u1FFC')
|(\'u2071')
|(\'u207F')
|(\'u2090'..'\u209C')
|(\'u2102')
|(\'u2107')
|(\'u210A'..'\u2113')
|(\'u2115')
|(\'u2118')
|(\'u2119'..'\u211D')
|(\'u2124')
|(\'u2126')
|(\'u2128')
|(\'u212A'..'\u212D')
|(\'u212E')
|(\'u212F'..'\u2134')
|(\'u2135'..'\u2138')
|(\'u2139')
|(\'u213C'..'\u213F')
|(\'u2145'..'\u2149')
|(\'u214E')
|(\'u2160'..'\u2182')
|(\'u2183'..'\u2184')
|(\'u2185'..'\u2188')
|(\'u2C00'..'\u2C2E')
|(\'u2C30'..'\u2C5E')
|(\'u2C60'..'\u2C7B')
|(\'u2C7C'..'\u2C7D')
|(\'u2C7E'..'\u2CE4')
|(\'u2CEB'..'\u2CEE')
|(\'u2CF2'..'\u2CF3')
|(\'u2D00'..'\u2D25')
|(\'u2D27')
|(\'u2D2D')
|(\'u2D30'..'\u2D67')
|(\'u2D6F')
|(\'u2D80'..'\u2D96')
|(\'u2DA0'..'\u2DA6')
|(\'u2DA8'..'\u2DAE')
|(\'u2DB0'..'\u2DB6')
|(\'u2DB8'..'\u2DBE')
|(\'u2DC0'..'\u2DC6')
|(\'u2DC8'..'\u2DCE')
|(\'u2DD0'..'\u2DD6')
|(\'u2DD8'..'\u2DDE')
|(\'u3005')
|(\'u3006')
|(\'u3007')
|(\'u3021'..'\u3029')
|(\'u3031'..'\u3035')
|(\'u3038'..'\u303A')
|(\'u303B')
|(\'u303C')
|(\'u3041'..'\u3096')
|(\'u309D'..'\u309E')
|(\'u309F')
|(\'u30A1'..'\u30FA')
|(\'u30FC'..'\u30FE')
|(\'u30FF')
|(\'u3105'..'\u312D')
|(\'u3131'..'\u318E')
|(\'u31A0'..'\u31BA')
|(\'u31F0'..'\u31FF')
|(\'u3400'..'\u4DB5')
|(\'u4E00'..'\u9FCC')
|(\'uA000'..'\uA014')
|(\'uA015')
|(\'uA016'..'\uA48C')
|(\'uA4D0'..'\uA4F7')
|(\'uA4F8'..'\uA4FD')
|(\'uA500'..'\uA60B')
|(\'uA60C')
|(\'uA610'..'\uA61F')
|(\'uA62A'..'\uA62B')
|(\'uA640'..'\uA66D')
|(\'uA66E')
|(\'uA67F')
|(\'uA680'..'\uA697')
|(\'uA6A0'..'\uA6E5')
|(\'uA6E6'..'\uA6EF')
|(\'uA717'..'\uA71F')
|(\'uA722'..'\uA76F')
|(\'uA770')
|(\'uA771'..'\uA787')
|(\'uA788')
|(\'uA78B'..'\uA78E')
|(\'uA790'..'\uA793')
|(\'uA7A0'..'\uA7AA')
|(\'uA7F8'..'\uA7F9')
|(\'uA7FA')
|(\'uA7FB'..'\uA801')
|(\'uA803'..'\uA805')
|(\'uA807'..'\uA80A')
|(\'uA80C'..'\uA822')
|(\'uA840'..'\uA873')
|(\'uA882'..'\uA8B3')
|(\'uA8F2'..'\uA8F7')
|(\'uA8FB')
|(\'uA90A'..'\uA925')
|(\'uA930'..'\uA946')
|(\'uA960'..'\uA97C')
|(\'uA984'..'\uA9B2')
|(\'uA9CF')
|(\'uAA00'..'\uAA28')
|(\'uAA40'..'\uAA42')
|(\'uAA44'..'\uAA4B')
|(\'uAA60'..'\uAA6F')
|(\'uAA70')
|(\'uAA71'..'\uAA76')
|(\'uAA7A')
|(\'uAA80'..'\uAAAF')
|(\'uAAB1')
|(\'uAAB5'..'\uAAB6')
|(\'uAAB9'..'\uAABD')
|(\'uAAC0')
|(\'uAAC2')
|(\'uAADB'..'\uAADC')
|(\'uAADD')
|(\'uAAE0'..'\uAAEA')
|(\'uAAF2')
|(\'uAAF3'..'\uAAF4')
|(\'uAB01'..'\uAB06')
|(\'uAB09'..'\uAB0E')
|(\'uAB11'..'\uAB16')
|(\'uAB20'..'\uAB26')
|(\'uAB28'..'\uAB2E')
|(\'uABC0'..'\uABE2')
|(\'uAC00'..'\uD7A3')
|(\'uD7B0'..'\uD7C6')
|(\'uD7CB'..'\uD7FB')
|(\'uF900'..'\uFA6D')
|(\'uFA70'..'\uFAD9')
|(\'uFB00'..'\uFB06')
|(\'uFB13'..'\uFB17')
|(\'uFB1D')
|(\'uFB1F'..'\uFB28')
|(\'uFB2A'..'\uFB36')
|(\'uFB38'..'\uFB3C')
|(\'uFB3E')
|(\'uFB40'..'\uFB41')
|(\'uFB43'..'\uFB44')
|(\'uFB46'..'\uFBB1')
|(\'uFBD3'..'\uFC5D')
|(\'uFC64'..'\uFD3D')
|(\'uFD50'..'\uFD8F')
|(\'uFD92'..'\uFDC7')
|(\'uFDF0'..'\uFDF9')
|(\'uFE71')
|(\'uFE73')
|(\'uFE77')
|(\'uFE79')
|(\'uFE7B')
|(\'uFE7D')
|(\'uFE7F'..'\uFEFC')
|(\'uFF21'..'\uFF3A')
|(\'uFF41'..'\uFF5A')
|(\'uFF66'..'\uFF6F')
|(\'uFF70')
|(\'uFF71'..'\uFF9D')
|(\'uFFA0'..'\uFFBE')
|(\'uFFC2'..'\uFFC7')
|(\'uFFCA'..'\uFFCF')
|(\'uFFD2'..'\uFFD7')
|(\'uFFDA'..'\uFFDC')
|(\'u10000'..'\u1000B')
|(\'u1000D'..'\u10026')
|(\'u10028'..'\u1003A')
|(\'u1003C'..'\u1003D')
|(\'u1003F'..'\u1004D')
|(\'u10050'..'\u1005D')
|(\'u10080'..'\u100FA')
|(\'u10140'..'\u10174')
|(\'u10280'..'\u1029C')
|(\'u102A0'..'\u102D0')
|(\'u10300'..'\u1031E')
|(\'u10330'..'\u10340')
|(\'u10341')
|(\'u10342'..'\u10349')
|(\'u1034A')
|(\'u10380'..'\u1039D')
|(\'u103A0'..'\u103C3')
|(\'u103C8'..'\u103CF')
|(\'u103D1'..'\u103D5')
|(\'u10400'..'\u1044F')
|(\'u10450'..'\u1049D')
|(\'u10800'..'\u10805')
|(\'u10808')
|(\'u1080A'..'\u10835')
|(\'u10837'..'\u10838')
|(\'u1083C')
|(\'u1083F'..'\u10855')
|(\'u10900'..'\u10915')
|(\'u10920'..'\u10939')
|(\'u10980'..'\u109B7')
|(\'u109BE'..'\u109BF')
|(\'u10A00')
|(\'u10A10'..'\u10A13')
|(\'u10A15'..'\u10A17')
|(\'u10A19'..'\u10A33')
|(\'u10A60'..'\u10A7C')
|(\'u10B00'..'\u10B35')
|(\'u10B40'..'\u10B55')
|(\'u10B60'..'\u10B72')
|(\'u10C00'..'\u10C48')
|(\'u11003'..'\u11037')
|(\'u11083'..'\u110AF')
|(\'u110D0'..'\u110E8')
|(\'u11103'..'\u11126')
|(\'u11183'..'\u111B2')
|(\'u111C1'..'\u111C4')
|(\'u11680'..'\u116AA')
|(\'u12000'..'\u1236E')
|(\'u12400'..'\u12462')
|(\'u13000'..'\u1342E')
|(\'u16800'..'\u16A38')
|(\'u16F00'..'\u16F44')
|(\'u16F50')
|(\'u16F93'..'\u16F9F')
|(\'u1B000'..'\u1B001')
|(\'u1D400'..'\u1D454')
|(\'u1D456'..'\u1D49C')
|(\'u1D49E'..'\u1D49F')
|(\'u1D4A2')
|(\'u1D4A5'..'\u1D4A6')
|(\'u1D4A9'..'\u1D4AC')
|(\'u1D4AE'..'\u1D4B9')
|(\'u1D4BB')
|(\'u1D4BD'..'\u1D4C3')
|(\'u1D4C5'..'\u1D505')
|(\'u1D507'..'\u1D50A')
|(\'u1D50D'..'\u1D514')
|(\'u1D516'..'\u1D51C')
|(\'u1D51E'..'\u1D539')
|(\'u1D53B'..'\u1D53E')
|(\'u1D540'..'\u1D544')
|(\'u1D546')
|(\'u1D54A'..'\u1D550')
|(\'u1D552'..'\u1D6A5')
|(\'u1D6A8'..'\u1D6C0')
|(\'u1D6C2'..'\u1D6DA')
|(\'u1D6DC'..'\u1D6FA')
|(\'u1D6FC'..'\u1D714')
|(\'u1D716'..'\u1D734')
|(\'u1D736'..'\u1D74E')
|(\'u1D750'..'\u1D76E')
|(\'u1D770'..'\u1D788')
|(\'u1D78A'..'\u1D7A8')
|(\'u1D7AA'..'\u1D7C2')
|(\'u1D7C4'..'\u1D7CB')
|(\'u1EE00'..'\u1EE03')
|(\'u1EE05'..'\u1EE1F')
|(\'u1EE21'..'\u1EE22')
|(\'u1EE24')
|(\'u1EE27')
|(\'u1EE29'..'\u1EE32')
|(\'u1EE34'..'\u1EE37')
|(\'u1EE39')
|(\'u1EE3B')
|(\'u1EE42')
|(\'u1EE47')
|(\'u1EE49')
|(\'u1EE4B')
|(\'u1EE4D'..'\u1EE4F')
|(\'u1EE51'..'\u1EE52')
|(\'u1EE54')
|(\'u1EE57')
|(\'u1EE59')
|(\'u1EE5B')
|(\'u1EE5D')
|(\'u1EE5F')
|(\'u1EE61'..'\u1EE62')
|(\'u1EE64')
|(\'u1EE67'..'\u1EE6A')
|(\'u1EE6C'..'\u1EE72')
|(\'u1EE74'..'\u1EE77')
|(\'u1EE79'..'\u1EE7C')
|(\'u1EE7E')
|(\'u1EE80'..'\u1EE89')
|(\'u1EE8B'..'\u1EE9B')
|(\'u1EEA1'..'\u1EEA3')
|(\'u1EEA5'..'\u1EEA9')
|(\'u1EEAB'..'\u1EEBB')
|(\'u20000'..'\u2A6D6')
|(\'u2A700'..'\u2B734')
|(\'u2B740'..'\u2B81D')
|(\'u2F800'..'\u2FA1D');
fragment XID_Continue:('0030'..'\u0039')
|('\u0041'..'\u005A')
|('\u005F')
|('\u0061'..'\u007A')
|('\u00AA')
|('\u00B5')
|('\u00B7')
|('\u00BA')
|('\u00C0'..'\u00D6')
|('\u00D8'..'\u00F6')
|('\u00F8'..'\u01BA')
|('\u01BB')
|('\u01BC'..'\u01BF')
|('\u01C0'..'\u01C3')
|('\u01C4'..'\u0293')
|('\u0294')
|('\u0295'..'\u02AF')
|('\u02B0'..'\u02C1')
|('\u02C6'..'\u02D1')
|('\u02E0'..'\u02E4')
|('\u02EC')
|('\u02EE')
|('\u0300'..'\u036F')
|('\u0370'..'\u0373')
|('\u0374')
|('\u0376'..'\u0377')
|('\u037B'..'\u037D')
|('\u0386')
|('\u0387')
|('\u0388'..'\u038A')
|('\u038C')
|('\u038E'..'\u03A1')
|('\u03A3'..'\u03F5')
|('\u03F7'..'\u0481')
|('\u0483'..'\u0487')
|('\u048A'..'\u0527')
|('\u0531'..'\u0556')
|('\u0559')
|('\u0561'..'\u0587')
|('\u0591'..'\u05BD')
|('\u05BF')
|('\u05C1'..'\u05C2')
|('\u05C4'..'\u05C5')
|('\u05C7')
|('\u05D0'..'\u05EA')
|('\u05F0'..'\u05F2')
|('\u0610'..'\u061A')
|('\u0620'..'\u063F')
|('\u0640')
|('\u0641'..'\u064A')
|('\u064B'..'\u065F')
|('\u0660'..'\u0669')
|('\u066E'..'\u066F')
|('\u0670')
|('\u0671'..'\u06D3')
|('\u06D5')
|('\u06D6'..'\u06DC')
|('\u06DF'..'\u06E4')
|('\u06E5'..'\u06E6')
|('\u06E7'..'\u06E8')
|('\u06EA'..'\u06ED')
|('\u06EE'..'\u06EF')
|('\u06F0'..'\u06F9')
|('\u06FA'..'\u06FC')
|('\u06FF')
|('\u0710')
|('\u0711')
|('\u0712'..'\u072F')
|('\u0730'..'\u074A')
|('\u074D'..'\u07A5')
|('\u07A6'..'\u07B0')
|('\u07B1')
|('\u07C0'..'\u07C9')
|('\u07CA'..'\u07EA')
|('\u07EB'..'\u07F3')
|('\u07F4'..'\u07F5')
|('\u07FA')
|('\u0800'..'\u0815')
|('\u0816'..'\u0819')
|('\u081A')
|('\u081B'..'\u0823')
|('\u0824')
|('\u0825'..'\u0827')
|('\u0828')
|('\u0829'..'\u082D')
|('\u0840'..'\u0858')
|('\u0859'..'\u085B')
|('\u08A0')
|('\u08A2'..'\u08AC')
|('\u08E4'..'\u08FE')
|('\u0900'..'\u0902')
|('\u0903')
|('\u0904'..'\u0939')
|('\u093A')
|('\u093B')
|('\u093C')
|('\u093D')
|('\u093E'..'\u0940')
|('\u0941'..'\u0948')
|('\u0949'..'\u094C')
|('\u094D')
|('\u094E'..'\u094F')
|('\u0950')
|('\u0951'..'\u0957')
|('\u0958'..'\u0961')
|('\u0962'..'\u0963')
|('\u0966'..'\u096F')
|('\u0971')
|('\u0972'..'\u0977')
|('\u0979'..'\u097F')
|('\u0981')
|('\u0982'..'\u0983')
|('\u0985'..'\u098C')
|('\u098F'..'\u0990')
|('\u0993'..'\u09A8')
|('\u09AA'..'\u09B0')
|('\u09B2')
|('\u09B6'..'\u09B9')
|('\u09BC')
|('\u09BD')
|('\u09BE'..'\u09C0')
|('\u09C1'..'\u09C4')
|('\u09C7'..'\u09C8')
|('\u09CB'..'\u09CC')
|('\u09CD')
|('\u09CE')
|('\u09D7')
|('\u09DC'..'\u09DD')
|('\u09DF'..'\u09E1')
|('\u09E2'..'\u09E3')
|('\u09E6'..'\u09EF')
|('\u09F0'..'\u09F1')
|('\u0A01'..'\u0A02')
|('\u0A03')
|('\u0A05'..'\u0A0A')
|('\u0A0F'..'\u0A10')
|('\u0A13'..'\u0A28')
|('\u0A2A'..'\u0A30')
|('\u0A32'..'\u0A33')
|('\u0A35'..'\u0A36')
|('\u0A38'..'\u0A39')
|('\u0A3C')
|('\u0A3E'..'\u0A40')
|('\u0A41'..'\u0A42')
|('\u0A47'..'\u0A48')
|('\u0A4B'..'\u0A4D')
|('\u0A51')
|('\u0A59'..'\u0A5C')
|('\u0A5E')
|('\u0A66'..'\u0A6F')
|('\u0A70'..'\u0A71')
|('\u0A72'..'\u0A74')
|('\u0A75')
|('\u0A81'..'\u0A82')
|('\u0A83')
|('\u0A85'..'\u0A8D')
|('\u0A8F'..'\u0A91')
|('\u0A93'..'\u0AA8')
|('\u0AAA'..'\u0AB0')
|('\u0AB2'..'\u0AB3')
|('\u0AB5'..'\u0AB9')
|('\u0ABC')
|('\u0ABD')
|('\u0ABE'..'\u0AC0')
|('\u0AC1'..'\u0AC5')
|('\u0AC7'..'\u0AC8')
|('\u0AC9')
|('\u0ACB'..'\u0ACC')
|('\u0ACD')
|('\u0AD0')
|('\u0AE0'..'\u0AE1')
|('\u0AE2'..'\u0AE3')
|('\u0AE6'..'\u0AEF')
|('\u0B01')
|('\u0B02'..'\u0B03')
|('\u0B05'..'\u0B0C')
|('\u0B0F'..'\u0B10')
|('\u0B13'..'\u0B28')
|('\u0B2A'..'\u0B30')
|('\u0B32'..'\u0B33')
|('\u0B35'..'\u0B39')
|('\u0B3C')
|('\u0B3D')
|('\u0B3E')
|('\u0B3F')
|('\u0B40')
|('\u0B41'..'\u0B44')
|('\u0B47'..'\u0B48')
|('\u0B4B'..'\u0B4C')
|('\u0B4D')
|('\u0B56')
|('\u0B57')
|('\u0B5C'..'\u0B5D')
|('\u0B5F'..'\u0B61')
|('\u0B62'..'\u0B63')
|('\u0B66'..'\u0B6F')
|('\u0B71')
|('\u0B82')
|('\u0B83')
|('\u0B85'..'\u0B8A')
|('\u0B8E'..'\u0B90')
|('\u0B92'..'\u0B95')
|('\u0B99'..'\u0B9A')
|('\u0B9C')
|('\u0B9E'..'\u0B9F')
|('\u0BA3'..'\u0BA4')
|('\u0BA8'..'\u0BAA')
|('\u0BAE'..'\u0BB9')
|('\u0BBE'..'\u0BBF')
|('\u0BC0')
|('\u0BC1'..'\u0BC2')
|('\u0BC6'..'\u0BC8')
|('\u0BCA'..'\u0BCC')
|('\u0BCD')
|('\u0BD0')
|('\u0BD7')
|('\u0BE6'..'\u0BEF')
|('\u0C01'..'\u0C03')
|('\u0C05'..'\u0C0C')
|('\u0C0E'..'\u0C10')
|('\u0C12'..'\u0C28')
|('\u0C2A'..'\u0C33')
|('\u0C35'..'\u0C39')
|('\u0C3D')
|('\u0C3E'..'\u0C40')
|('\u0C41'..'\u0C44')
|('\u0C46'..'\u0C48')
|('\u0C4A'..'\u0C4D')
|('\u0C55'..'\u0C56')
|('\u0C58'..'\u0C59')
|('\u0C60'..'\u0C61')
|('\u0C62'..'\u0C63')
|('\u0C66'..'\u0C6F')
|('\u0C82'..'\u0C83')
|('\u0C85'..'\u0C8C')
|('\u0C8E'..'\u0C90')
|('\u0C92'..'\u0CA8')
|('\u0CAA'..'\u0CB3')
|('\u0CB5'..'\u0CB9')
|('\u0CBC')
|('\u0CBD')
|('\u0CBE')
|('\u0CBF')
|('\u0CC0'..'\u0CC4')
|('\u0CC6')
|('\u0CC7'..'\u0CC8')
|('\u0CCA'..'\u0CCB')
|('\u0CCC'..'\u0CCD')
|('\u0CD5'..'\u0CD6')
|('\u0CDE')
|('\u0CE0'..'\u0CE1')
|('\u0CE2'..'\u0CE3')
|('\u0CE6'..'\u0CEF')
|('\u0CF1'..'\u0CF2')
|('\u0D02'..'\u0D03')
|('\u0D05'..'\u0D0C')
|('\u0D0E'..'\u0D10')
|('\u0D12'..'\u0D3A')
|('\u0D3D')
|('\u0D3E'..'\u0D40')
|('\u0D41'..'\u0D44')
|('\u0D46'..'\u0D48')
|('\u0D4A'..'\u0D4C')
|('\u0D4D')
|('\u0D4E')
|('\u0D57')
|('\u0D60'..'\u0D61')
|('\u0D62'..'\u0D63')
|('\u0D66'..'\u0D6F')
|('\u0D7A'..'\u0D7F')
|('\u0D82'..'\u0D83')
|('\u0D85'..'\u0D96')
|('\u0D9A'..'\u0DB1')
|('\u0DB3'..'\u0DBB')
|('\u0DBD')
|('\u0DC0'..'\u0DC6')
|('\u0DCA')
|('\u0DCF'..'\u0DD1')
|('\u0DD2'..'\u0DD4')
|('\u0DD6')
|('\u0DD8'..'\u0DDF')
|('\u0DF2'..'\u0DF3')
|('\u0E01'..'\u0E30')
|('\u0E31')
|('\u0E32'..'\u0E33')
|('\u0E34'..'\u0E3A')
|('\u0E40'..'\u0E45')
|('\u0E46')
|('\u0E47'..'\u0E4E')
|('\u0E50'..'\u0E59')
|('\u0E81'..'\u0E82')
|('\u0E84')
|('\u0E87'..'\u0E88')
|('\u0E8A')
|('\u0E8D')
|('\u0E94'..'\u0E97')
|('\u0E99'..'\u0E9F')
|('\u0EA1'..'\u0EA3')
|('\u0EA5')
|('\u0EA7')
|('\u0EAA'..'\u0EAB')
|('\u0EAD'..'\u0EB0')
|('\u0EB1')
|('\u0EB2'..'\u0EB3')
|('\u0EB4'..'\u0EB9')
|('\u0EBB'..'\u0EBC')
|('\u0EBD')
|('\u0EC0'..'\u0EC4')
|('\u0EC6')
|('\u0EC8'..'\u0ECD')
|('\u0ED0'..'\u0ED9')
|('\u0EDC'..'\u0EDF')
|('\u0F00')
|('\u0F18'..'\u0F19')
|('\u0F20'..'\u0F29')
|('\u0F35')
|('\u0F37')
|('\u0F39')
|('\u0F3E'..'\u0F3F')
|('\u0F40'..'\u0F47')
|('\u0F49'..'\u0F6C')
|('\u0F71'..'\u0F7E')
|('\u0F7F')
|('\u0F80'..'\u0F84')
|('\u0F86'..'\u0F87')
|('\u0F88'..'\u0F8C')
|('\u0F8D'..'\u0F97')
|('\u0F99'..'\u0FBC')
|('\u0FC6')
|('\u1000'..'\u102A')
|('\u102B'..'\u102C')
|('\u102D'..'\u1030')
|('\u1031')
|('\u1032'..'\u1037')
|('\u1038')
|('\u1039'..'\u103A')
|('\u103B'..'\u103C')
|('\u103D'..'\u103E')
|('\u103F')
|('\u1040'..'\u1049')
|('\u1050'..'\u1055')
|('\u1056'..'\u1057')
|('\u1058'..'\u1059')
|('\u105A'..'\u105D')
|('\u105E'..'\u1060')
|('\u1061')
|('\u1062'..'\u1064')
|('\u1065'..'\u1066')
|('\u1067'..'\u106D')
|('\u106E'..'\u1070')
|('\u1071'..'\u1074')
|('\u1075'..'\u1081')
|('\u1082')
|('\u1083'..'\u1084')
|('\u1085'..'\u1086')
|('\u1087'..'\u108C')
|('\u108D')
|('\u108E')
|('\u108F')
|('\u1090'..'\u1099')
|('\u109A'..'\u109C')
|('\u109D')
|('\u10A0'..'\u10C5')
|('\u10C7')
|('\u10CD')
|('\u10D0'..'\u10FA')
|('\u10FC')
|('\u10FD'..'\u1248')
|('\u124A'..'\u124D')
|('\u1250'..'\u1256')
|('\u1258')
|('\u125A'..'\u125D')
|('\u1260'..'\u1288')
|('\u128A'..'\u128D')
|('\u1290'..'\u12B0')
|('\u12B2'..'\u12B5')
|('\u12B8'..'\u12BE')
|('\u12C0')
|('\u12C2'..'\u12C5')
|('\u12C8'..'\u12D6')
|('\u12D8'..'\u1310')
|('\u1312'..'\u1315')
|('\u1318'..'\u135A')
|('\u135D'..'\u135F')
|('\u1369'..'\u1371')
|('\u1380'..'\u138F')
|('\u13A0'..'\u13F4')
|('\u1401'..'\u166C')
|('\u166F'..'\u167F')
|('\u1681'..'\u169A')
|('\u16A0'..'\u16EA')
|('\u16EE'..'\u16F0')
|('\u1700'..'\u170C')
|('\u170E'..'\u1711')
|('\u1712'..'\u1714')
|('\u1720'..'\u1731')
|('\u1732'..'\u1734')
|('\u1740'..'\u1751')
|('\u1752'..'\u1753')
|('\u1760'..'\u176C')
|('\u176E'..'\u1770')
|('\u1772'..'\u1773')
|('\u1780'..'\u17B3')
|('\u17B4'..'\u17B5')
|('\u17B6')
|('\u17B7'..'\u17BD')
|('\u17BE'..'\u17C5')
|('\u17C6')
|('\u17C7'..'\u17C8')
|('\u17C9'..'\u17D3')
|('\u17D7')
|('\u17DC')
|('\u17DD')
|('\u17E0'..'\u17E9')
|('\u180B'..'\u180D')
|('\u1810'..'\u1819')
|('\u1820'..'\u1842')
|('\u1843')
|('\u1844'..'\u1877')
|('\u1880'..'\u18A8')
|('\u18A9')
|('\u18AA')
|('\u18B0'..'\u18F5')
|('\u1900'..'\u191C')
|('\u1920'..'\u1922')
|('\u1923'..'\u1926')
|('\u1927'..'\u1928')
|('\u1929'..'\u192B')
|('\u1930'..'\u1931')
|('\u1932')
|('\u1933'..'\u1938')
|('\u1939'..'\u193B')
|('\u1946'..'\u194F')
|('\u1950'..'\u196D')
|('\u1970'..'\u1974')
|('\u1980'..'\u19AB')
|('\u19B0'..'\u19C0')
|('\u19C1'..'\u19C7')
|('\u19C8'..'\u19C9')
|('\u19D0'..'\u19D9')
|('\u19DA')
|('\u1A00'..'\u1A16')
|('\u1A17'..'\u1A18')
|('\u1A19'..'\u1A1B')
|('\u1A20'..'\u1A54')
|('\u1A55')
|('\u1A56')
|('\u1A57')
|('\u1A58'..'\u1A5E')
|('\u1A60')
|('\u1A61')
|('\u1A62')
|('\u1A63'..'\u1A64')
|('\u1A65'..'\u1A6C')
|('\u1A6D'..'\u1A72')
|('\u1A73'..'\u1A7C')
|('\u1A7F')
|('\u1A80'..'\u1A89')
|('\u1A90'..'\u1A99')
|('\u1AA7')
|('\u1B00'..'\u1B03')
|('\u1B04')
|('\u1B05'..'\u1B33')
|('\u1B34')
|('\u1B35')
|('\u1B36'..'\u1B3A')
|('\u1B3B')
|('\u1B3C')
|('\u1B3D'..'\u1B41')
|('\u1B42')
|('\u1B43'..'\u1B44')
|('\u1B45'..'\u1B4B')
|('\u1B50'..'\u1B59')
|('\u1B6B'..'\u1B73')
|('\u1B80'..'\u1B81')
|('\u1B82')
|('\u1B83'..'\u1BA0')
|('\u1BA1')
|('\u1BA2'..'\u1BA5')
|('\u1BA6'..'\u1BA7')
|('\u1BA8'..'\u1BA9')
|('\u1BAA')
|('\u1BAB')
|('\u1BAC'..'\u1BAD')
|('\u1BAE'..'\u1BAF')
|('\u1BB0'..'\u1BB9')
|('\u1BBA'..'\u1BE5')
|('\u1BE6')
|('\u1BE7')
|('\u1BE8'..'\u1BE9')
|('\u1BEA'..'\u1BEC')
|('\u1BED')
|('\u1BEE')
|('\u1BEF'..'\u1BF1')
|('\u1BF2'..'\u1BF3')
|('\u1C00'..'\u1C23')
|('\u1C24'..'\u1C2B')
|('\u1C2C'..'\u1C33')
|('\u1C34'..'\u1C35')
|('\u1C36'..'\u1C37')
|('\u1C40'..'\u1C49')
|('\u1C4D'..'\u1C4F')
|('\u1C50'..'\u1C59')
|('\u1C5A'..'\u1C77')
|('\u1C78'..'\u1C7D')
|('\u1CD0'..'\u1CD2')
|('\u1CD4'..'\u1CE0')
|('\u1CE1')
|('\u1CE2'..'\u1CE8')
|('\u1CE9'..'\u1CEC')
|('\u1CED')
|('\u1CEE'..'\u1CF1')
|('\u1CF2'..'\u1CF3')
|('\u1CF4')
|('\u1CF5'..'\u1CF6')
|('\u1D00'..'\u1D2B')
|('\u1D2C'..'\u1D6A')
|('\u1D6B'..'\u1D77')
|('\u1D78')
|('\u1D79'..'\u1D9A')
|('\u1D9B'..'\u1DBF')
|('\u1DC0'..'\u1DE6')
|('\u1DFC'..'\u1DFF')
|('\u1E00'..'\u1F15')
|('\u1F18'..'\u1F1D')
|('\u1F20'..'\u1F45')
|('\u1F48'..'\u1F4D')
|('\u1F50'..'\u1F57')
|('\u1F59')
|('\u1F5B')
|('\u1F5D')
|('\u1F5F'..'\u1F7D')
|('\u1F80'..'\u1FB4')
|('\u1FB6'..'\u1FBC')
|('\u1FBE')
|('\u1FC2'..'\u1FC4')
|('\u1FC6'..'\u1FCC')
|('\u1FD0'..'\u1FD3')
|('\u1FD6'..'\u1FDB')
|('\u1FE0'..'\u1FEC')
|('\u1FF2'..'\u1FF4')
|('\u1FF6'..'\u1FFC')
|('\u203F'..'\u2040')
|('\u2054')
|('\u2071')
|('\u207F')
|('\u2090'..'\u209C')
|('\u20D0'..'\u20DC')
|('\u20E1')
|('\u20E5'..'\u20F0')
|('\u2102')
|('\u2107')
|('\u210A'..'\u2113')
|('\u2115')
|('\u2118')
|('\u2119'..'\u211D')
|('\u2124')
|('\u2126')
|('\u2128')
|('\u212A'..'\u212D')
|('\u212E')
|('\u212F'..'\u2134')
|('\u2135'..'\u2138')
|('\u2139')
|('\u213C'..'\u213F')
|('\u2145'..'\u2149')
|('\u214E')
|('\u2160'..'\u2182')
|('\u2183'..'\u2184')
|('\u2185'..'\u2188')
|('\u2C00'..'\u2C2E')
|('\u2C30'..'\u2C5E')
|('\u2C60'..'\u2C7B')
|('\u2C7C'..'\u2C7D')
|('\u2C7E'..'\u2CE4')
|('\u2CEB'..'\u2CEE')
|('\u2CEF'..'\u2CF1')
|('\u2CF2'..'\u2CF3')
|('\u2D00'..'\u2D25')
|('\u2D27')
|('\u2D2D')
|('\u2D30'..'\u2D67')
|('\u2D6F')
|('\u2D7F')
|('\u2D80'..'\u2D96')
|('\u2DA0'..'\u2DA6')
|('\u2DA8'..'\u2DAE')
|('\u2DB0'..'\u2DB6')
|('\u2DB8'..'\u2DBE')
|('\u2DC0'..'\u2DC6')
|('\u2DC8'..'\u2DCE')
|('\u2DD0'..'\u2DD6')
|('\u2DD8'..'\u2DDE')
|('\u2DE0'..'\u2DFF')
|('\u3005')
|('\u3006')
|('\u3007')
|('\u3021'..'\u3029')
|('\u302A'..'\u302D')
|('\u302E'..'\u302F')
|('\u3031'..'\u3035')
|('\u3038'..'\u303A')
|('\u303B')
|('\u303C')
|('\u3041'..'\u3096')
|('\u3099'..'\u309A')
|('\u309D'..'\u309E')
|('\u309F')
|('\u30A1'..'\u30FA')
|('\u30FC'..'\u30FE')
|('\u30FF')
|('\u3105'..'\u312D')
|('\u3131'..'\u318E')
|('\u31A0'..'\u31BA')
|('\u31F0'..'\u31FF')
|('\u3400'..'\u4DB5')
|('\u4E00'..'\u9FCC')
|('\uA000'..'\uA014')
|('\uA015')
|('\uA016'..'\uA48C')
|('\uA4D0'..'\uA4F7')
|('\uA4F8'..'\uA4FD')
|('\uA500'..'\uA60B')
|('\uA60C')
|('\uA610'..'\uA61F')
|('\uA620'..'\uA629')
|('\uA62A'..'\uA62B')
|('\uA640'..'\uA66D')
|('\uA66E')
|('\uA66F')
|('\uA674'..'\uA67D')
|('\uA67F')
|('\uA680'..'\uA697')
|('\uA69F')
|('\uA6A0'..'\uA6E5')
|('\uA6E6'..'\uA6EF')
|('\uA6F0'..'\uA6F1')
|('\uA717'..'\uA71F')
|('\uA722'..'\uA76F')
|('\uA770')
|('\uA771'..'\uA787')
|('\uA788')
|('\uA78B'..'\uA78E')
|('\uA790'..'\uA793')
|('\uA7A0'..'\uA7AA')
|('\uA7F8'..'\uA7F9')
|('\uA7FA')
|('\uA7FB'..'\uA801')
|('\uA802')
|('\uA803'..'\uA805')
|('\uA806')
|('\uA807'..'\uA80A')
|('\uA80B')
|('\uA80C'..'\uA822')
|('\uA823'..'\uA824')
|('\uA825'..'\uA826')
|('\uA827')
|('\uA840'..'\uA873')
|('\uA880'..'\uA881')
|('\uA882'..'\uA8B3')
|('\uA8B4'..'\uA8C3')
|('\uA8C4')
|('\uA8D0'..'\uA8D9')
|('\uA8E0'..'\uA8F1')
|('\uA8F2'..'\uA8F7')
|('\uA8FB')
|('\uA900'..'\uA909')
|('\uA90A'..'\uA925')
|('\uA926'..'\uA92D')
|('\uA930'..'\uA946')
|('\uA947'..'\uA951')
|('\uA952'..'\uA953')
|('\uA960'..'\uA97C')
|('\uA980'..'\uA982')
|('\uA983')
|('\uA984'..'\uA9B2')
|('\uA9B3')
|('\uA9B4'..'\uA9B5')
|('\uA9B6'..'\uA9B9')
|('\uA9BA'..'\uA9BB')
|('\uA9BC')
|('\uA9BD'..'\uA9C0')
|('\uA9CF')
|('\uA9D0'..'\uA9D9')
|('\uAA00'..'\uAA28')
|('\uAA29'..'\uAA2E')
|('\uAA2F'..'\uAA30')
|('\uAA31'..'\uAA32')
|('\uAA33'..'\uAA34')
|('\uAA35'..'\uAA36')
|('\uAA40'..'\uAA42')
|('\uAA43')
|('\uAA44'..'\uAA4B')
|('\uAA4C')
|('\uAA4D')
|('\uAA50'..'\uAA59')
|('\uAA60'..'\uAA6F')
|('\uAA70')
|('\uAA71'..'\uAA76')
|('\uAA7A')
|('\uAA7B')
|('\uAA80'..'\uAAAF')
|('\uAAB0')
|('\uAAB1')
|('\uAAB2'..'\uAAB4')
|('\uAAB5'..'\uAAB6')
|('\uAAB7'..'\uAAB8')
|('\uAAB9'..'\uAABD')
|('\uAABE'..'\uAABF')
|('\uAAC0')
|('\uAAC1')
|('\uAAC2')
|('\uAADB'..'\uAADC')
|('\uAADD')
|('\uAAE0'..'\uAAEA')
|('\uAAEB')
|('\uAAEC'..'\uAAED')
|('\uAAEE'..'\uAAEF')
|('\uAAF2')
|('\uAAF3'..'\uAAF4')
|('\uAAF5')
|('\uAAF6')
|('\uAB01'..'\uAB06')
|('\uAB09'..'\uAB0E')
|('\uAB11'..'\uAB16')
|('\uAB20'..'\uAB26')
|('\uAB28'..'\uAB2E')
|('\uABC0'..'\uABE2')
|('\uABE3'..'\uABE4')
|('\uABE5')
|('\uABE6'..'\uABE7')
|('\uABE8')
|('\uABE9'..'\uABEA')
|('\uABEC')
|('\uABED')
|('\uABF0'..'\uABF9')
|('\uAC00'..'\uD7A3')
|('\uD7B0'..'\uD7C6')
|('\uD7CB'..'\uD7FB')
|('\uF900'..'\uFA6D')
|('\uFA70'..'\uFAD9')
|('\uFB00'..'\uFB06')
|('\uFB13'..'\uFB17')
|('\uFB1D')
|('\uFB1E')
|('\uFB1F'..'\uFB28')
|('\uFB2A'..'\uFB36')
|('\uFB38'..'\uFB3C')
|('\uFB3E')
|('\uFB40'..'\uFB41')
|('\uFB43'..'\uFB44')
|('\uFB46'..'\uFBB1')
|('\uFBD3'..'\uFC5D')
|('\uFC64'..'\uFD3D')
|('\uFD50'..'\uFD8F')
|('\uFD92'..'\uFDC7')
|('\uFDF0'..'\uFDF9')
|('\uFE00'..'\uFE0F')
|('\uFE20'..'\uFE26')
|('\uFE33'..'\uFE34')
|('\uFE4D'..'\uFE4F')
|('\uFE71')
|('\uFE73')
|('\uFE77')
|('\uFE79')
|('\uFE7B')
|('\uFE7D')
|('\uFE7F'..'\uFEFC')
|('\uFF10'..'\uFF19')
|('\uFF21'..'\uFF3A')
|('\uFF3F')
|('\uFF41'..'\uFF5A')
|('\uFF66'..'\uFF6F')
|('\uFF70')
|('\uFF71'..'\uFF9D')
|('\uFF9E'..'\uFF9F')
|('\uFFA0'..'\uFFBE')
|('\uFFC2'..'\uFFC7')
|('\uFFCA'..'\uFFCF')
|('\uFFD2'..'\uFFD7')
|('\uFFDA'..'\uFFDC')
|('\u10000'..'\u1000B')
|('\u1000D'..'\u10026')
|('\u10028'..'\u1003A')
|('\u1003C'..'\u1003D')
|('\u1003F'..'\u1004D')
|('\u10050'..'\u1005D')
|('\u10080'..'\u100FA')
|('\u10140'..'\u10174')
|('\u101FD')
|('\u10280'..'\u1029C')
|('\u102A0'..'\u102D0')
|('\u10300'..'\u1031E')
|('\u10330'..'\u10340')
|('\u10341')
|('\u10342'..'\u10349')
|('\u1034A')
|('\u10380'..'\u1039D')
|('\u103A0'..'\u103C3')
|('\u103C8'..'\u103CF')
|('\u103D1'..'\u103D5')
|('\u10400'..'\u1044F')
|('\u10450'..'\u1049D')
|('\u104A0'..'\u104A9')
|('\u10800'..'\u10805')
|('\u10808')
|('\u1080A'..'\u10835')
|('\u10837'..'\u10838')
|('\u1083C')
|('\u1083F'..'\u10855')
|('\u10900'..'\u10915')
|('\u10920'..'\u10939')
|('\u10980'..'\u109B7')
|('\u109BE'..'\u109BF')
|('\u10A00')
|('\u10A01'..'\u10A03')
|('\u10A05'..'\u10A06')
|('\u10A0C'..'\u10A0F')
|('\u10A10'..'\u10A13')
|('\u10A15'..'\u10A17')
|('\u10A19'..'\u10A33')
|('\u10A38'..'\u10A3A')
|('\u10A3F')
|('\u10A60'..'\u10A7C')
|('\u10B00'..'\u10B35')
|('\u10B40'..'\u10B55')
|('\u10B60'..'\u10B72')
|('\u10C00'..'\u10C48')
|('\u11000')
|('\u11001')
|('\u11002')
|('\u11003'..'\u11037')
|('\u11038'..'\u11046')
|('\u11066'..'\u1106F')
|('\u11080'..'\u11081')
|('\u11082')
|('\u11083'..'\u110AF')
|('\u110B0'..'\u110B2')
|('\u110B3'..'\u110B6')
|('\u110B7'..'\u110B8')
|('\u110B9'..'\u110BA')
|('\u110D0'..'\u110E8')
|('\u110F0'..'\u110F9')
|('\u11100'..'\u11102')
|('\u11103'..'\u11126')
|('\u11127'..'\u1112B')
|('\u1112C')
|('\u1112D'..'\u11134')
|('\u11136'..'\u1113F')
|('\u11180'..'\u11181')
|('\u11182')
|('\u11183'..'\u111B2')
|('\u111B3'..'\u111B5')
|('\u111B6'..'\u111BE')
|('\u111BF'..'\u111C0')
|('\u111C1'..'\u111C4')
|('\u111D0'..'\u111D9')
|('\u11680'..'\u116AA')
|('\u116AB')
|('\u116AC')
|('\u116AD')
|('\u116AE'..'\u116AF')
|('\u116B0'..'\u116B5')
|('\u116B6')
|('\u116B7')
|('\u116C0'..'\u116C9')
|('\u12000'..'\u1236E')
|('\u12400'..'\u12462')
|('\u13000'..'\u1342E')
|('\u16800'..'\u16A38')
|('\u16F00'..'\u16F44')
|('\u16F50')
|('\u16F51'..'\u16F7E')
|('\u16F8F'..'\u16F92')
|('\u16F93'..'\u16F9F')
|('\u1B000'..'\u1B001')
|('\u1D165'..'\u1D166')
|('\u1D167'..'\u1D169')
|('\u1D16D'..'\u1D172')
|('\u1D17B'..'\u1D182')
|('\u1D185'..'\u1D18B')
|('\u1D1AA'..'\u1D1AD')
|('\u1D242'..'\u1D244')
|('\u1D400'..'\u1D454')
|('\u1D456'..'\u1D49C')
|('\u1D49E'..'\u1D49F')
|('\u1D4A2')
|('\u1D4A5'..'\u1D4A6')
|('\u1D4A9'..'\u1D4AC')
|('\u1D4AE'..'\u1D4B9')
|('\u1D4BB')
|('\u1D4BD'..'\u1D4C3')
|('\u1D4C5'..'\u1D505')
|('\u1D507'..'\u1D50A')
|('\u1D50D'..'\u1D514')
|('\u1D516'..'\u1D51C')
|('\u1D51E'..'\u1D539')
|('\u1D53B'..'\u1D53E')
|('\u1D540'..'\u1D544')
|('\u1D546')
|('\u1D54A'..'\u1D550')
|('\u1D552'..'\u1D6A5')
|('\u1D6A8'..'\u1D6C0')
|('\u1D6C2'..'\u1D6DA')
|('\u1D6DC'..'\u1D6FA')
|('\u1D6FC'..'\u1D714')
|('\u1D716'..'\u1D734')
|('\u1D736'..'\u1D74E')
|('\u1D750'..'\u1D76E')
|('\u1D770'..'\u1D788')
|('\u1D78A'..'\u1D7A8')
|('\u1D7AA'..'\u1D7C2')
|('\u1D7C4'..'\u1D7CB')
|('\u1D7CE'..'\u1D7FF')
|('\u1EE00'..'\u1EE03')
|('\u1EE05'..'\u1EE1F')
|('\u1EE21'..'\u1EE22')
|('\u1EE24')
|('\u1EE27')
|('\u1EE29'..'\u1EE32')
|('\u1EE34'..'\u1EE37')
|('\u1EE39')
|('\u1EE3B')
|('\u1EE42')
|('\u1EE47')
|('\u1EE49')
|('\u1EE4B')
|('\u1EE4D'..'\u1EE4F')
|('\u1EE51'..'\u1EE52')
|('\u1EE54')
|('\u1EE57')
|('\u1EE59')
|('\u1EE5B')
|('\u1EE5D')
|('\u1EE5F')
|('\u1EE61'..'\u1EE62')
|('\u1EE64')
|('\u1EE67'..'\u1EE6A')
|('\u1EE6C'..'\u1EE72')
|('\u1EE74'..'\u1EE77')
|('\u1EE79'..'\u1EE7C')
|('\u1EE7E')
|('\u1EE80'..'\u1EE89')
|('\u1EE8B'..'\u1EE9B')
|('\u1EEA1'..'\u1EEA3')
|('\u1EEA5'..'\u1EEA9')
|('\u1EEAB'..'\u1EEBB')
|('\u20000'..'\u2A6D6')
|('\u2A700'..'\u2B734')
|('\u2B740'..'\u2B81D')
|('\u2F800'..'\u2FA1D')
|('\uE0100'..'\uE01EF')
;*/