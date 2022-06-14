#!/usr/bin/env python

"""string_fun.py: takes in user input and alters input based on user selection of choices"""

import sys

print('Hello, this script will alter strings for you.\n')

# Outer main while loop, allows user to enter a new string
while True:
    user_string = input('Please enter a string you would like to '
    'alter (press enter to skip to exit option):\n')
    # Inner main while loop, keeps asking for input if user makes an invaldi choice
    while True:
        user_selection = input('\nPlease make a selection from the following choices: '
            '\n1.) Reverse string''\n2.) Iterate String \n3.) Slice String (start to index)'
            '\n4.) Find String Lenght \n5.) exit\n\n')
        # Check if user input is correct, if not user prompted and inner while loop continues
        if int(user_selection) > 0 and int(user_selection) < 6:
            # user selection control statemenets, all but last break back to outer main while loop
            if user_selection == '1':
                print('\nReverse of given string is: ' + user_string[::-1] + '\n')
                break
            if user_selection == '2':
                # Iterate string
                print(' ')
                for c in user_string:
                    print(c, end=' ')
                print('\n')
                break
            if user_selection == '3':
                # While loop to keep asking for correct input, until it is given
                while True:
                    user_slice = int(input('\nPlease enter index where you want to slice string'
                    'from: 0 to ' + str(len(user_string)) + '\n'))
                    # Check user input, if good complete operation, else prompt user
                    if user_slice <= len(user_string):
                        print('\nSliced at index: ' + str(user_slice) + ', '
                         + user_string[:user_slice] + '\n')
                        break
                    print('Your selction was out of range, try again.')
                    continue
                break
            if user_selection == '4':
                print('\nLength of given string is: ' + str(len(user_string)) + '\n')
                break
            if user_selection == '5':
                print('\nQuiting program, hope you have a great day!')
                sys.exit()
        else:
            print('\nYou have made an invalid selection, please choose between choices 1 thru 5.')
            continue
