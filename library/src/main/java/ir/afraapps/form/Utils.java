package ir.afraapps.form;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In the name of Allah
 * <p>
 * Created by Ali Jabbari on 11/2/2023.
 */
class Utils {

  public static void selectChilds(ViewGroup viewGroup, boolean select) {
    if (viewGroup == null) return;
    int childCount = viewGroup.getChildCount();
    for (int i = 0; i < childCount; i++) {
      View child = viewGroup.getChildAt(i);
      child.setSelected(select);
      if (child instanceof ViewGroup) {
        selectChilds((ViewGroup) child, select);
      }
    }
  }


  static int getAttrColor(Context context, int attr, int defaultColor) {
    TypedValue typedValue = new TypedValue();

    TypedArray a = context.obtainStyledAttributes(typedValue.data, new int[]{attr});
    int color = a.getColor(0, defaultColor);
    a.recycle();

    return color;
  }


  static boolean isMobileNumber(String number) {
    Pattern pattern = Pattern.compile("^(((\\+|00)98)|98|0)?9[01239]\\d{8}$");
    Matcher matcher = pattern.matcher(number);
    return matcher.matches();
  }


  static boolean isAllPhoneNumber(String number) {
    Pattern pattern = Pattern.compile("^(((\\+|00)98)|98|0)?[1-9]\\d{9}$");
    Matcher matcher = pattern.matcher(number);
    return matcher.matches();
  }


  static boolean isNationalCode(String number) {
    Pattern pattern = Pattern.compile("^\\d{10}$");
    Matcher matcher = pattern.matcher(number);
    return matcher.matches();
  }


  static boolean isEmail(String email) {
    Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(email);
    return matcher.matches();
  }
}
