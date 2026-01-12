# Brownfield MadCore Project

## Project Overview

This is a Brownfield MadCore project located at `E:\Code\demo1`. Brownfield MadCore is a development framework designed to facilitate both brownfield (existing codebase) and greenfield (new project) development workflows. The project includes a comprehensive set of tools, templates, and workflows to support agile software development.

### Key Components

- **Configuration System**: Managed through `.bmad-core/core-config.yaml`
- **Workflows**: Predefined development workflows for different project types
- **Templates**: Standardized templates for documentation and project structure
- **Agents**: Specialized roles defined as part of the development team
- **Checklists**: Quality assurance and process checklists

## Architecture

The project follows the MadCore architecture with the following key directories:

- `.bmad-core/`: Core framework files and configurations
  - `agent-teams/`: Team composition definitions
  - `agents/`: Individual agent role definitions (PO, PM, Dev, QA, etc.)
  - `checklists/`: Process and quality checklists
  - `data/`: Supporting data files
  - `tasks/`: Defined tasks and processes
  - `templates/`: Documentation templates
  - `utils/`: Utility scripts and documentation
  - `workflows/`: Predefined project workflows

## Configuration

The project is configured through `core-config.yaml` which defines:

- PRD (Product Requirements Document) handling
- Architecture documentation settings
- Development story locations
- Debug logging paths

## Building and Running

Since this is a MadCore framework project, traditional build/run commands don't apply directly. Instead, the framework provides:

1. **Workflow Management**: Use predefined workflows for different project types
2. **Story Creation**: Generate development stories based on requirements
3. **Documentation Generation**: Automated documentation from templates

To work with this project:

1. Familiarize yourself with the available workflows in `.bmad-core/workflows/`
2. Review the agent roles in `.bmad-core/agents/` to understand team responsibilities
3. Use the templates in `.bmad-core/templates/` for consistent documentation

## Development Conventions

The MadCore framework enforces certain development conventions:

- Story-driven development using the `.bmad-core/tasks/create-next-story.md` process
- Quality gates defined in `.bmad-core/tasks/qa-gate.md`
- Requirement tracing through `.bmad-core/tasks/trace-requirements.md`

## Key Files

- `.bmad-core/core-config.yaml`: Main project configuration
- `.bmad-core/install-manifest.yaml`: Framework installation details
- `.bmad-core/user-guide.md`: User documentation for the framework
- `.bmad-core/enhanced-ide-development-workflow.md`: Enhanced IDE workflow documentation

## Usage

This project serves as a template for using the Brownfield MadCore framework. To begin development:

1. Choose an appropriate workflow from `.bmad-core/workflows/`
2. Customize the configuration in `core-config.yaml` as needed
3. Follow the defined processes and checklists for consistent development
4. Use the agent system to assign roles and responsibilities