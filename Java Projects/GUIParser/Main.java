/**
 * Author: Lindley, Thomas
 * Date: 11/17/2020
 * Project: project 1 CMSC 330 Advanced Programming
 * Purpose: parse text files based on provided GUI language
 */

/**
 * gui ::= Window STRING '(' NUMBER ',' NUMBER ')' nt_layout widgets_nt End '.'
 * layout ::= Layout nt_layout_type_nt ':'
 * layout_type ::= Flow | Grid '(' NUMBER ',' NUMBER [',' NUMBER ',' NUMBER] ')'
 * widgets ::= nt_widget widgets_nt | nt_widget_nt
 * widget ::= Button STRING ';' | Group nt_radio_buttons_nt End ';' | Label STRING ';' | Panel nt_layout widgets_nt End ';'
 *       | Textfield NUMBER ';'
 * radio_buttons ::= nt_radio_button_nt nt_radio_buttons_nt | nt_radio_button_nt
 * radio_button ::= Radio STRING ';'
 */
public class Main {
    public static void main(String[] args) {
        GUIParse a = new GUIParse();
    }
}
