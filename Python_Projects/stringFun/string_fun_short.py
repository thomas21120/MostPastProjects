#!/usr/bin/env python
"""string_fun_short.py: takes in user input and slices it"""
import sys
user_string = input('Please enter a string you would like to '
    'alter (press enter to skip to exit option):\n')
user_slice = int(input('\nPlease enter index where you want to slice string'
    'from: 0 to ' + str(len(user_string)) + '\n'))
while True:
    # Check user input, if good complete operation, else prompt user
    if user_slice <= len(user_string):
        print('\nSliced at index: ' + str(user_slice) + ', '
            + user_string[:user_slice] + '\n')
        break
    print('Your selction was out of range, try again.')
    continue
sys.exit()
