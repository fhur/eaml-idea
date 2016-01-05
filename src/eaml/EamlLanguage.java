package eaml;

import com.intellij.lang.Language;

/**
 * Created by fernandohur on 11/24/15.
 */
public class EamlLanguage extends Language {

    public static EamlLanguage INSTANCE = new EamlLanguage();

    public EamlLanguage() {
        super("eaml");
    }
}
