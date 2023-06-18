# Stage 3/4: Make it notable
## Description
Now, let's change the font of the text. The new font will be larger and will consist of multiple rows and columns of standard console symbols.

The new font is shown below:
```
____ ___  ____ ___  ____ ____ ____ _  _ _  _ _  _ _    _  _
|__| |__] |    |  \ |___ |___ | __ |__| |  | |_/  |    |\/|
|  | |__] |___ |__/ |___ |    |__] |  | | _| | \_ |___ |  |
_  _ ____ ___  ____ ____ ____ ___ _  _ _  _ _ _ _ _  _ _   _ ___ 
|\ | |  | |__] |  | |__/ [__   |  |  | |  | | | |  \/   \_/    /
| \| |__| |    |_\| |  \ ___]  |  |__|  \/  |_|_| _/\_   |    /__
```

Look carefully at the new output example:
```
Enter name and surname: Bill Gates
Enter person's status: VIP
***************************************************
*  ___  _ _    _         ____ ____ ___ ____ ____  *
*  |__] | |    |         | __ |__|  |  |___ [__   *
*  |__] | |___ |___      |__] |  |  |  |___ ___]  *
*                       VIP                       *
***************************************************
```

The tag contains the name and the status.

The name includes the first and the last name separated by a space. It should be printed using the provided font.

The status could be "VIP", "Employee", "Speaker", "Administrator", "Participant", or something else. These statuses should appear on the tag below the person's name (without additional line spacing). This information is not as important as the name, so it should be printed in a smaller font.

In some cases, the width of the tag may have an even number of symbols, while the status has an odd number of symbols (or vice versa). In these cases, you cannot generate a horizontally centered status, since it will always be offset by one extra space on the left or on the right. In this case, your program should move the status to the left so there is one space less to the left of the status than to the right.

## Objectives
Your program should read a person's first and last names and status from standard input and create a personal name tag. The name should be printed with the provided font and the personal status with a regular font.

The program has the following requirements:

- Personal status is printed below the personal name (without blank lines between them).

- The name and status should sit right in the middle of the line. If, due to the number of symbols, the status cannot be centered, the program should leave an extra space to the right of it.

- If the name is longer than the status, leave two spaces to the left and to the right of the name. Otherwise, leave two spaces to the left and to the right of the status. Note that there should not be empty lines between the top border and the name.

Some details about the font style:

- The font has uppercase letters only. It is made of the following symbols: `_`, `|`, `/`, `\`, `]`, `[`.

- The first name and the last name should contain a column of single spaces between the adjacent letters for better readability.

- The interval between the first and the last name should contain six spaces including indents.

`Every letter in the font is 3-symbol high and 4-symbol wide, except I, J, T, W, and Y.`

For example, the letter “`A`” is 3-symbol high and 4-symbol wide:

![letter “A”](a.png)

As you can see, each letter contains a column of whitespaces as a delimiter.

![Spaces between letters as a delimiter](ab.png)
Spaces between letters as a delimiter

We suggest saving the font in one of the two following ways:

1) Save the alphabet as a list of 3 string list's containing the symbols of the three rows. Note that letters in the font are separated by a column of spaces:

![Alphabet](alphabet.png)

2) You can also save each letter as a List of strings (top, middle, bottom). Example:
```
mutableListOf("____", "|__|", "|  |") // A
```
Or you can think of a method of your own!

## Examples
Note that strings `Enter the first and last name:` and `Enter the person's status:` are not part of the input.

### Example 1:
```
Enter name and surname: Bill Gates
Enter person's status: VIP
***************************************************
*  ___  _ _    _         ____ ____ ___ ____ ____  *
*  |__] | |    |         | __ |__|  |  |___ [__   *
*  |__] | |___ |___      |__] |  |  |  |___ ___]  *
*                       VIP                       *
***************************************************
```

### Example 2:
```
Enter name and surname: Tom Smith
Enter person's status: Worker
*********************************************
*  ___ ____ _  _      ____ _  _ _ ___ _  _  *
*   |  |  | |\/|      [__  |\/| |  |  |__|  *
*   |  |__| |  |      ___] |  | |  |  |  |  *
*                  Worker                   *
*********************************************
```

### Example 3:
```
Enter name and surname: Mr Anonimous
Enter person's status: Participant
**************************************************************
*  _  _ ____      ____ _  _ ____ _  _ _ _  _ ____ _  _ ____  *
*  |\/| |__/      |__| |\ | |  | |\ | | |\/| |  | |  | [__   *
*  |  | |  \      |  | | \| |__| | \| | |  | |__| |__| ___]  *
*                        Participant                         *
**************************************************************
```

### Example 4:
```
Enter name and surname: John S
Enter person's status: Worker-coworker-superdupercoworker
****************************************
*      _ ____ _  _ _  _      ____      *
*      | |  | |__| |\ |      [__       *
*     _| |__| |  | | \|      ___]      *
*  Worker-coworker-superdupercoworker  *
****************************************
```
