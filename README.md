# Airtable Timeline Assignment

## Implementation Time

Approximately 3.5 hours

## What I Like About My Implementation

- **Clean Architecture**: The implementation follows MVVM pattern with clear separation of concerns between UI, business logic, and data layers
- **Efficient Layout Algorithm**: The timeline layout engine efficiently arranges events in compact swimlanes, minimizing vertical space usage
- **Responsive Design**: The timeline automatically adjusts to different screen sizes and event configurations
- **Self-Documenting Code**: Components are named and structured to clearly express their responsibilities without excessive comments
- **Material Design 3**: Uses modern Material Design components for a polished, professional appearance
- **Performance**: Leverages Compose's efficient rendering and state management

## What I Would Change If I Were Going to Do It Again

- **Enhanced Interactivity**: Add drag-and-drop functionality for event editing and timeline navigation
- **Zoom Functionality**: Implement timeline zooming for better navigation of long timelines
- **Event Details**: Add click-to-expand functionality for viewing detailed event information
- **Timeline Navigation**: Add horizontal scrolling and navigation controls for long timelines
- **Event Filtering**: Implement filtering and search capabilities for large numbers of events
- **Responsive Layout**: Improve the layout for different screen orientations and sizes

## Design Decisions

- **Swimlane Algorithm**: I designed a custom algorithm that sorts events by start date and assigns them to the first available lane, ensuring optimal space utilization
- **Proportional Sizing**: Event widths are proportional to their duration, making it easy to visually compare event lengths
- **Lane Management**: Events that don't overlap can share lanes, reducing vertical space requirements
- **Material Design**: Chose Material Design 3 for consistency with modern Android apps and accessibility
- **Compose Architecture**: Used Compose for declarative UI with clear state management through ViewModel
- **Custom Layout Engine**: Avoided external timeline libraries to demonstrate custom implementation skills

## Testing Strategy

If I had more time, I would implement:

- **Unit Tests**: Test the timeline layout algorithm with various event configurations
- **UI Tests**: Test the timeline rendering and event positioning
- **Integration Tests**: Test the complete flow from data to UI rendering
- **Performance Tests**: Test with large numbers of events to ensure scalability
- **Accessibility Tests**: Ensure the timeline is usable with screen readers and other assistive technologies

## Build and Run Instructions

1. **Prerequisites**: Android Studio Hedgehog or later, JDK 17
2. **Clone the repository**: `git clone <repository-url>`
3. **Open in Android Studio**: Open the project in Android Studio
4. **Sync Gradle**: Wait for Gradle sync to complete
5. **Run on device/emulator**: Click the Run button or use `./gradlew installDebug`

## Project Structure

```
app/src/main/java/com/airtable/interview/airtableschedule/
├── MainActivity.kt                 # Main activity entry point
├── models/
│   ├── Event.kt                   # Event data model
│   └── SampleTimelineItems.kt     # Sample data for testing
├── repositories/
│   └── EventDataRepository.kt     # Data access layer
├── timeline/
│   ├── TimelineScreen.kt          # Main timeline screen
│   ├── TimelineComponents.kt      # Timeline UI components
│   ├── TimelineLayoutEngine.kt    # Custom layout algorithm
│   ├── TimelineViewModel.kt       # ViewModel for state management
│   └── TimelineUiState.kt         # UI state data class
└── theme/                         # App theming
```

## Key Features Implemented

- **Multi-lane Timeline**: Events are arranged in compact swimlanes
- **Proportional Event Sizing**: Event width corresponds to duration
- **Efficient Space Usage**: Non-overlapping events share lanes
- **Responsive Layout**: Adapts to different screen sizes
- **Clean UI**: Modern Material Design 3 interface
- **State Management**: Proper MVVM architecture with ViewModel

## Technical Highlights

- **Custom Layout Algorithm**: Implemented from scratch without external timeline libraries
- **Compose UI**: Modern declarative UI framework
- **MVVM Architecture**: Clean separation of concerns
- **Kotlin Coroutines**: Asynchronous data handling
- **Material Design 3**: Latest design system components
