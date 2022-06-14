"""voter_registration.py: script takes in user information to register to vote"""
import sys
print('****************************************************************')
print('Welcome to the voter registration application.\n')

def do_you_continue():
    """function do_you_continue(), asks user if they want to continue, quits if no"""
    while True:
        user_in_continue = (input('Do you want to continue with '
        'Voter Registration? (Y/N)\n')).upper()
        if user_in_continue == 'Y':
            break
        if user_in_continue == 'N':
            sys.exit()
        print('Please enter Y or N\n')
do_you_continue()

user_first_name = input('What is your first name?\n')
do_you_continue()

user_Last_name = input('What is your last name?\n')
do_you_continue()

# get age, make sure it is in range, quits if not
while True:
    try:
        user_age = int(input('What is your age?\n'))
    except ValueError:
        print('Please enter your age containing integers only.\n')
        continue
    break

if user_age < 18 or user_age > 120:
    user_age = int(input('Age out of range please re-enter.\n'))
    if user_age < 18 or user_age > 120:
        sys.exit()
do_you_continue()

# US citizen check, checks valid input Y/N, N will exit program
while True:
    user_citizen = (input('Are you a U.S. citizen? (Y/N)\n')).upper()
    if user_citizen == 'Y':
        break
    if user_citizen == 'N':
        print('You must be a U.S. citizen to be eligible to vote.\n'
        'Program will now exit. Have a great day.')
        sys.exit()
    print('Please enter Y or N\n')
do_you_continue()

# Get users state, ensures valid state entered
while True:
    user_state = (input('What state do you live in '
    '(2 letter state abbreviation)?\n')).upper()
    if len(user_state) == 2:
        if (user_state[0] >= 'A' and user_state[0] <= 'Z' and
            user_state[1] >= 'A' and user_state[1] <= 'Z'):
            break
        print('Please enter a valid state, letters only.\n')
        continue
    if len(user_state) != 2:
        print('Please enter a valid state, 2 letters.\n')
do_you_continue()

# get useres zipcode, ensures proper length and integers
while True:
    user_zip = input('What is your zipcode?\n')
    if len(user_zip) == 5:
        try:
            int(user_zip)
        except ValueError:
            print('\nPlease enter a valid zipcode containing integers only.\n')
            continue
        break
    if len(user_zip) != 5:
        print('\nPlease enter a valid length zipcode.\n')
do_you_continue()

# output user info and if registration was successful
if user_citizen == 'Y':
    print('Thanks for registering to vote, your registration is valid.'
    ' Here is the information received:\n''Name (First & Last): ' +
    str(user_first_name) + ' ' + str(user_Last_name) + '\n' + 'Age: ' + str(user_age) +
    '\n' + 'U.S. Citizen: ' + str(user_citizen) + '\n' +
    'State: ' + str(user_state) + '\n' + 'Zipcode: ' + str(user_zip) + '\n')
    sys.exit()
