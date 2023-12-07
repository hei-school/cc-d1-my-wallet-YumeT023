package com.yumii.tui;

import com.yumii.core.Transaction;
import com.yumii.core.Wallet;
import java.util.List;

import static java.lang.String.format;

public class Printer {
  public static void printLogo() {
    System.out.println("""
         __       __            __  __              __              \s
          /  |  _  /  |          /  |/  |            /  |             \s
          $$ | / \\ $$ |  ______  $$ |$$ |  ______   _$$ |_    __    __\s
          $$ |/$  \\$$ | /      \\ $$ |$$ | /      \\ / $$   |  /  |  /  |
          $$ /$$$  $$ | $$$$$$  |$$ |$$ |/$$$$$$  |$$$$$$/   $$ |  $$ |
          $$ $$/$$ $$ | /    $$ |$$ |$$ |$$    $$ |  $$ | __ $$ |  $$ |
          $$$$/  $$$$ |/$$$$$$$ |$$ |$$ |$$$$$$$$/   $$ |/  |$$ \\__$$ |
          $$$/    $$$ |$$    $$ |$$ |$$ |$$       |  $$  $$/ $$    $$ |
          $$/      $$/  $$$$$$$/ $$/ $$/  $$$$$$$/    $$$$/   $$$$$$$ |
                                                             /  \\__$$ |
                                                             $$    $$/\s
                                                              $$$$$$/\s
        """);
  }

  public static void printList(List<String> items) {
    for (int i = 0; i < items.size(); i++) {
      var item = items.get(i);
      System.out.println(format("%d - %s", i + 1, item));
    }
  }

  public static void printHr(int time) {
    System.out.println("-".repeat(time));
  }

  public static void printHeader(String header) {
    System.out.println(header);
    printHr(header.length() * 2);
  }

  public static void printWallet(Wallet wallet) {
    printHeader("Wallet state");
    System.out.println(format("owner   \t%s", wallet.getOwner()));
    System.out.println(format("balance \t%s", wallet.getBalance()));
  }

  public static void printHistory(List<Transaction> history) {
    printHeader("History");
    history.forEach(transaction -> {
      System.out.println(format("%s\t%f", transaction.type(), transaction.amount()));
    });
  }
}
