#!/usr/bin/env python

"""string_fun.py: takes in user input and alters input based on user selection of choices"""

import sys

print('Hello, this script will alter strings for you.\n')

# Outer main while loop, allows user to enter a new string
while True:
    user_string = input('Please enter a string you would like to '
    'alter (press enter to skip to exit option):\n')
    # Inner main while loop, keeps asking for input if user makes an invald choice
    while True:
        try:
            user_selection = int(input('\nPlease make a selection from the following choices: '
                '\n1.) Reverse string''\n2.) Iterate String \n3.) Slice String (start to index)'
                '\n4.) Find String Length \n5.) exit\n\n'))
            if user_selection > 5:
                raise ValueError
        except ValueError:
            print('---Please make a choice from the list of choices, previous selection invalid')
            continue

        # user selection control statements
        # all continue the main while loop to allow another selection
        if user_selection == 1:
            print('\nReverse of given string is: ' + user_string[::-1] + '\n')
            input('Press enter to continue.')
            continue

        if user_selection == 2:
            # Iterate string
            print(' ')
            for c in user_string:
                print(c, end=' ')
            print('\n')
            input('Press enter to continue.')
            continue

        if user_selection == 3:
            # While loop to keep asking for correct input, until it is given
            while True:
                try:
                    user_slice = int(input('\nPlease enter index where you want to slice string'
                        'from: 0 to ' + str(len(user_string)) + '\n'))
                except ValueError:
                    print('---Please enter integer for index.---')
                # Check user input, if good complete operation, else prompt user
                print('\nSliced at index: ' + str(user_slice) + ', '
                    + user_string[:user_slice] + '\n')
                break
            input('Press enter to continue.')
            continue

        if user_selection == 4:
            print('\nLength of given string is: ' + str(len(user_string)) + '\n')
            input('Press enter to continue.')
            continue

        if user_selection == 5:
            print('\nQuiting program, hope you have a great day!')
            sys.exit()
