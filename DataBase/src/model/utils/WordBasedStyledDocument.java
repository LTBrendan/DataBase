package model.utils;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;

/**
 * This class allow to replace specific words by the same ones but in an other font
 */
public class WordBasedStyledDocument extends DefaultStyledDocument {

	private static final long serialVersionUID = 1L;
	private Style _defaultStyle;
    private Style _cwStyle;

    /**
     * The constructor
     * @param defaultStyle the default font
     * @param cwStyle the new font
     */
    public WordBasedStyledDocument(Style defaultStyle, Style cwStyle) {
        _defaultStyle =  defaultStyle;
        _cwStyle = cwStyle;
    }

     /**
      * This method to replace the former word by the new one with the new font
      * @param offset the index where to insert the string
      * @param str the string to insert
      * @param offset the index where to insert the string
      * @param a the attribute of the inserted string
      */
    public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
         super.insertString(offset, str, a);
         refreshDocument();
     }

    /**
     * This method remove a word
     * @param offs the index where the word begin
     * @param len the word length
     */
     public void remove (int offs, int len) throws BadLocationException {
         super.remove(offs, len);
         refreshDocument();
     }

     /**
      * This method refresh the document
      * @throws BadLocationException
      */
    private synchronized void refreshDocument() throws BadLocationException {
         String text = getText(0, getLength());
         final List<HiliteWord> list = processWords(text);

         setCharacterAttributes(0, text.length(), _defaultStyle, true);   
         for(HiliteWord word : list) {
             int p0 = word._position;
             setCharacterAttributes(p0, word._word.length(), _cwStyle, true);
         }
     }       


     /**
      * This method detect what and where are the reserved words
      * @param content the content to analyze
      * @return the high lighted words
      */
    private static  List<HiliteWord> processWords(String content) {
         content += " ";
         List<HiliteWord> hiliteWords = new ArrayList<HiliteWord>();
         int lastWhitespacePosition = 0;
         String word = "";
         char[] data = content.toCharArray();

         for(int index=0; index < data.length; index++) {
             char ch = data[index];
             if(!(Character.isLetter(ch) || Character.isDigit(ch) || ch == '_')) {
                 lastWhitespacePosition = index;
                 if(word.length() > 0) {
                     if(isReservedWord(word)) {
                         hiliteWords.add(new HiliteWord(word,(lastWhitespacePosition - word.length())));
                     }
                     word="";
                 }
             }
             else {
                 word += ch;
             }
        }
        return hiliteWords;
     }

     /**
      * This method contain all the reserved words
      * @param word the word to check
      * @return true only if word is contained in the list
      */
    private static final boolean isReservedWord(String word) {
         return(word.toUpperCase().trim().equals("AND") ||
                 word.toUpperCase().trim().equals("COUNT") ||
                 word.toUpperCase().trim().equals("CREATE") ||
        		 word.toUpperCase().trim().equals("CROSS") || 
                        word.toUpperCase().trim().equals("CURRENT_DATE") ||
                        word.toUpperCase().trim().equals("CURRENT_TIME") ||
                        word.toUpperCase().trim().equals("CURRENT_TIMESTAMP") ||
                        word.toUpperCase().trim().equals("DELETE") ||
                        word.toUpperCase().trim().equals("DISTINCT") ||
                        word.toUpperCase().trim().equals("DROP") ||
                        word.toUpperCase().trim().equals("EXCEPT") ||
                        word.toUpperCase().trim().equals("EXISTS") ||
                        word.toUpperCase().trim().equals("FALSE") ||
                        word.toUpperCase().trim().equals("FETCH") ||
                        word.toUpperCase().trim().equals("FOR") ||
                        word.toUpperCase().trim().equals("FROM") ||
                        word.toUpperCase().trim().equals("FULL") ||
                        word.toUpperCase().trim().equals("GROUP") ||
                        word.toUpperCase().trim().equals("HAVING") ||
                        word.toUpperCase().trim().equals("INNER") ||
                        word.toUpperCase().trim().equals("INSERT") ||
                        word.toUpperCase().trim().equals("INTERSECT") ||
                        word.toUpperCase().trim().equals("INTO") ||
                        word.toUpperCase().trim().equals("IS") ||
                        word.toUpperCase().trim().equals("JOIN") ||
                        word.toUpperCase().trim().equals("LIKE") ||
                        word.toUpperCase().trim().equals("LIMIT") ||
                        word.toUpperCase().trim().equals("MINUS") ||
                        word.toUpperCase().trim().equals("NATURAL") ||
                        word.toUpperCase().trim().equals("NOT") ||
                        word.toUpperCase().trim().equals("NULL") ||
                        word.toUpperCase().trim().equals("OFFSET") ||
                        word.toUpperCase().trim().equals("ON") ||
                        word.toUpperCase().trim().equals("ORDER") ||
                        word.toUpperCase().trim().equals("PRIMARY") ||
                        word.toUpperCase().trim().equals("ROWNUM") ||
                        word.toUpperCase().trim().equals("SELECT") ||
                        word.toUpperCase().trim().equals("SYSDATE") ||
                        word.toUpperCase().trim().equals("SYSTIME") ||
                        word.toUpperCase().trim().equals("SYSTIMESTAMP") ||
                        word.toUpperCase().trim().equals("TODAY") ||
                        word.toUpperCase().trim().equals("TRUE") ||
                        word.toUpperCase().trim().equals("UNION") ||
                        word.toUpperCase().trim().equals("UNIQUE") ||
                        word.toUpperCase().trim().equals("VALUES") ||
                        word.toUpperCase().trim().equals("WHERE"));
    }
	

}
