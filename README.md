# ao3_project

App development project with Jordan, Teddy, and Edo

### Useful git commands

| Command | Function |
| ----------- | ----------- |
| git status | Which branch am i on? What's the status of every file? |
| git remote -v | What is my remote origin? |
| git log | What's the history of commits on this branch? |
| git diff | What's the difference between my files? (need further explanation) |
| git pull | Updates local branch from remote branch |
| git push | Updates local from remote |

### How do I work locally?

1. `git clone [url]` 
*Downloads the repository as a folder in current directory.*

2. `cd repo`
`git branch my-branch`
*Creates local branch called "my-branch".*

3. `git checkout my-branch`
*Switches workspace to local branch called "my-branch".*

4. `git add [files]`
`git commit -m "Commit message`
*Stages and commits changes to the local branch.*

5. `git push --set-upstream origin my-branch`
*Pushes working branch to remote branch also called "my-branch"*

### How do I initialize a local repository?

1. `git init my-repo` 
*Initializes the repository as a folder.*
2. `cd my-repo` 
`touch README.md` 
`git add README.md` 
*Creates and stages README file.*
3. `git commit -m "add README to initial commit"` 
*Makes initial commit.*
4. `git remote add origin https://github.com/username/project.git` 
*Adds remote origin.*
5. `git push --set-upstream origin main` 
*Pushes to main branch.*

