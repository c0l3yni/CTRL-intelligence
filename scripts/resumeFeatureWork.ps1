# Run script to resume working in an existing feature branch while ensuring that feature branch is up to date with the latest changes in devleop.

# Set current branch name
$branchName = git rev-parse --abbrev-ref HEAD 

# Confirm you are in a feature branch
if ($branchName -eq 'develop') {
    ""
    Write-Host -ForegroundColor blue "====================================== RESULT =========================================="
    ""
    Write-Host -ForegroundColor red "Unable to run command from develop. Please checkout an existing feature branch."
    ""
    Write-Host -ForegroundColor blue "========================================================================================"
    return
} else {
    git stash
    git pull
    git checkout develop
    git pull
    git checkout $branchName
    git merge develop
    git stash pop

    ""
    Write-Host -ForegroundColor blue "====================================== RESULT =========================================="
    ""
    Write-Host -ForegroundColor green "$branchName includes the latest code from the develop branch."
    ""
    Write-Host -ForegroundColor blue "========================================================================================"
}