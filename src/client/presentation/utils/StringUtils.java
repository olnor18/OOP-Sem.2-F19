/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.presentation.utils;

import com.google.common.primitives.Chars;
import java.util.List;

/**
 *
 * @author Oliver
 */
public class StringUtils
{
    public static String getBoldString(String s)
    {
        List<Character> input = Chars.asList(s.toCharArray());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.size(); i++)
        {
            if (Character.isLowerCase(input.get(i)))
            {
                sb.append(Character.toChars(120205+input.get(i)));
            }
            else if (Character.isUpperCase(input.get(i)))
            {
                sb.append(Character.toChars(119743+input.get(i)));
            }
            else
            {
                sb.append(input.get(i));
            }
        }
        return sb.toString();
    }
}
